package com.example.quetionacademy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.quetionacademy.animationuttils.SpinnerTransformation
import com.example.quetionacademy.answer.AnswerActivity
import com.example.quetionacademy.utils.PagerDecorator
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity(), PagerListener {

    private val viewModelQuestion: MainViewModel by viewModels()
    private val adapter by lazy{
        PagerAdapter(this)  // this для listner interface
    }

    private var questionResult = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
         setupViewpager()

    }


    override fun onBackPressed() { /// метод для обратного скрола на предыдущий ответ!!!!! (важно)
        if (pager.currentItem >0) {
            pager.currentItem -= 1
        } else {
            super.onBackPressed()
        }
    }

    private fun generateData(): ArrayList<String> {
        val list = arrayListOf<String>()
        list.add(getString(R.string.iuoi))
        list.add(getString(R.string.te))
        list.add(getString(R.string.dhfh))
        list.add(getString(R.string.th))
        list.add(getString(R.string.tfgd))
        list.add(getString(R.string.hgfd))
        return list
    }

    private fun setupViewpager() {
        pager.adapter = adapter
        adapter.update(generateData())
        pager.isUserInputEnabled = false // чтоб не скролился
        pager.offscreenPageLimit = 6
        pager.setPageTransformer(SpinnerTransformation()) /// для анимации SpinnerTransformation() это класс с анимцией
        pager.addItemDecoration(PagerDecorator()) // от класса PageDecorator для отступа в пикселях
    }

    override fun selectAnswer(answer: Boolean, position: Int) {
        if (position >= 4 && !answer)
            questionResult += 20
        if (position < 4 && answer) questionResult += 20 // баллы за ответ
        if (!answer) questionResult += 0 // вопрос!!!!
        Log.d("fsgsd",questionResult.toString())

        nextPage(position)
    }
    override fun selectAnswerForbuttons(position: Int, points: Int) { // position: Int, points: Int все из Interface listener
        questionResult += points
        nextPage(position)
    }

    private fun nextPage(position: Int){
        pager.currentItem += 1  // перевод на другую страницу при клике да нет
        if (position + 1 == adapter.itemCount)  { // для прехода с вопрос активити на ответ активити
            val intent = Intent(this, AnswerActivity :: class.java)
            intent.putExtra(POINTS, questionResult)
            startActivity(intent)
            finish()
        }
    }

    companion object {
        const val  POINTS = "POINTS"
    }
}
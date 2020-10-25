package com.example.quetionacademy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
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
        setupListeners()
    }

    private fun setupListeners() {
        next.setOnClickListener {
            pager.currentItem += 1
        }
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
        list.add("У вас есть проблемы\n" +
                "с иммунитетом?")
        list.add("fdsdgsgsdsdfgdfgd")
        list.add("fdsdgsgsdsdfgdfgdwwwww")
        list.add("fdsdgsgsdsdfgdfgdwwwww")
        list.add("fdsdgsgsdsdfgdfgdwwwww")
        list.add("fdsdgsgsdsdfgdfgdwwwww")
        return list
    }

    private fun setupViewpager() {
        pager.adapter = adapter
        adapter.update(generateData())
        pager.isUserInputEnabled = false // чтоб не скролился
    }

    override fun selectAnswer(answer: Boolean) {
        pager.currentItem += 1  // перевод на другую страницу при клике да нет
        if (answer) questionResult += 10  // балл при нажатии на да
    }
}
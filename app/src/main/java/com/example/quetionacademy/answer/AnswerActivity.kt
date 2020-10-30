package com.example.quetionacademy.answer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.getString
import com.example.quetionacademy.MainActivity
import com.example.quetionacademy.QuestionActivity.Companion.POINTS
import com.example.quetionacademy.R
import com.example.quetionacademy.enumutils.EnumResult
import com.example.quetionacademy.utils.ClickSpan
import kotlinx.android.synthetic.main.answer_one.*

class AnswerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.answer_one)

        val points = intent.getIntExtra(POINTS ,-1) //-1 значен по умолчан
        val result = EnumResult.selectTypeOfEnum(points) // EnumResult.selectTypeOfEnum обратились из EnumResult class companion object


        parentLayout.setBackgroundResource(result.parentDrawble)
        divider.setBackgroundResource(result.drawbleDivider)
        mainText.text = getString(result.textTitle )
        secondText.text = getString(result.smallTitle)
        mainText.setTextColor(resources.getColor(result.color))
        secondText.setTextColor(resources.getColor(result.color))
        getSpan(result)


        btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun getSpan(result: EnumResult) {
        tvThird.text = getString(result.fullText)
        ClickSpan.clickify(tvThird,
                getString(result.fullTextColor),
                getColor(result.color)
        ){}
    }
}
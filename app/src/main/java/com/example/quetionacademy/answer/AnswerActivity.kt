package com.example.quetionacademy.answer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quetionacademy.QuestionActivity.Companion.POINTS
import com.example.quetionacademy.R
import kotlinx.android.synthetic.main.answer_one.*

class AnswerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.answer_one)

        val points = intent.getIntExtra(POINTS ,-1) //-1 значен по умолчан
        when {
            points <= 20 -> {
                parentLayout.setBackgroundResource(R.drawable.dark_greenbackre)
                divider.setBackgroundResource(R.drawable.bg_view_darkgreen)
                mainText.text = getString(R.string.title_green)
                secondText.text = getString(R.string.smallText_green)
                mainText.setTextColor(resources.getColor(R.color.green))
                secondText.setTextColor(resources.getColor(R.color.green))
                tvThird.text = getString(R.string.fullText_green)
            }
            points in 21..39 -> {
                parentLayout.setBackgroundResource(R.drawable.yellow_backgr)
                divider.setBackgroundResource(R.drawable.bg_view_yellow)
                mainText.text = getString(R.string.title_yellow)
                mainText.setTextColor(resources.getColor(R.color.yellow))
                secondText.text = getString(R.string.smallText_yellow)
                secondText.setTextColor(resources.getColor(R.color.yellow))
                tvThird.text = getString(R.string.fullText_yellow)
            }
            points <= 60 -> {
                parentLayout.setBackgroundResource(R.drawable.green_backgr)
                divider.setBackgroundResource(R.drawable.bg_view_green)
                mainText.text = getString(R.string.title_lightgreen)
                mainText.setTextColor(resources.getColor(R.color.lightgreen))
                secondText.text = getString(R.string.smallText_lightgreen)
                secondText.setTextColor(resources.getColor(R.color.lightgreen))
                tvThird.text = getString(R.string.fullText_lightgreen)
            }
            points in 40..59 -> {
                parentLayout.setBackgroundResource(R.drawable.orange)
                divider.setBackgroundResource(R.drawable.bg_view_orange)
                mainText.text = getString(R.string.title_orange)
                mainText.setTextColor(resources.getColor(R.color.orange))
                secondText.text = getString(R.string.smallText_orange)
                secondText.setTextColor(resources.getColor(R.color.orange))
                tvThird.text = getString(R.string.fullText_orange)
            }
            else -> {
                parentLayout.setBackgroundResource(R.drawable.red_backgr)
                divider.setBackgroundResource(R.drawable.bg_view_red)
                mainText.text = getString(R.string.title_red)
                mainText.setTextColor(resources.getColor(R.color.red))
                secondText.text = getString(R.string.smallText_red)
                secondText.setTextColor(resources.getColor(R.color.red))
                tvThird.text = getString(R.string.fullText_red)
            }
        }
    }
}
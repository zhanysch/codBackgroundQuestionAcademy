package com.example.quetionacademy.enumutils

import android.provider.Settings.Global.getString
import com.example.quetionacademy.R
import kotlinx.android.synthetic.main.answer_one.*

enum class EnumResult(
        val parentDrawble : Int,
        val drawbleDivider: Int,
        val textTitle : Int,
        val smallTitle: Int,
        val color : Int,
        val fullText : Int,
        val fullTextColor : Int
) {
    GREEN(
            R.drawable.dark_greenbackre,
            R.drawable.bg_view_darkgreen,
            R.string.title_green,
            R.string.smallText_green,
            R.color.green,
            R.string.fullText_green,
            R.string.fullText_colorGreen
    ),

    YELLOW(
            R.drawable.yellow_backgr,
            R.drawable.bg_view_yellow,
            R.string.title_yellow,
            R.string.smallText_yellow,
            R.color.yellow,
            R.string.fullText_yellow,
            R.string.fullText_colorYellow
    ),

    LIGHTGREEN(
            R.drawable.green_backgr,
            R.drawable.bg_view_green,
            R.string.title_lightgreen,
            R.string.smallText_lightgreen,
            R.color.lightgreen,
            R.string.fullText_lightgreen,
            R.string.ligthgreen_fulltext
    ),

    ORANGE(
            R.drawable.orange,
            R.drawable.bg_view_orange,
            R.string.title_orange,
            R.string.smallText_orange,
            R.color.orange,
            R.string.fullText_orange,
            R.string.fullText_colorOrange
    ),
    RED(
            R.drawable.red_backgr,
            R.drawable.bg_view_red,
            R.string.title_red,
            R.string.smallText_red,
            R.color.red,
            R.string.fullText_red,
            R.string.fullText_colorRed
    );

    companion object {  // с помошью обжект обратились в AnswerActivity-> EnumResult.selectTypeOfEnum()
        fun selectTypeOfEnum(points: Int, ): EnumResult {   // вопрос!!!
           return when {
                points == 20 -> GREEN
                points in 21..39 -> YELLOW
                points == 0 ->  LIGHTGREEN
                points in 40..59 -> ORANGE
                else -> RED
            }

        }
    }
}
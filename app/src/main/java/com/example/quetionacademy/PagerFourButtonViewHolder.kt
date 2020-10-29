package com.example.quetionacademy

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_question.view.tvcount
import kotlinx.android.synthetic.main.item_questionthree.view.*


class PagerFourButtonViewHolder(view: View): RecyclerView.ViewHolder(view){
    fun bind(s: String, position: Int, size: Int, listener: PagerListener) {

        itemView.tvQuestionfour.text = s
        // "${position+1}/$size" position, list.size для выхода на экране страниц 1/1 1/2 1/3 ..
        itemView.tvcount.text = itemView.context.resources.
        getString(R.string.question_number,
                    position+1 , size)

            itemView.btnzero.setOnClickListener {
                listener.selectAnswerForbuttons(0,position)  // 0 это баллы и позиция
            }
         itemView.btnfive.setOnClickListener {
            listener.selectAnswerForbuttons(15,position)
         }


        itemView.btnone.setOnClickListener {
             listener.selectAnswerForbuttons(10,position)
            }

        itemView.btnten.setOnClickListener {
            listener.selectAnswerForbuttons(20,position)
        }
    }
}

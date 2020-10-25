package com.example.quetionacademy

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_question.view.*


class PagerFourButtonViewHolder(view: View): RecyclerView.ViewHolder(view){
    fun bind(s: String, position: Int, size: Int, listener: PagerListener) {
        // "${position+1}/$size" position, list.size для выхода на экране страниц 1/1 1/2 1/3 ..
        itemView.tvcount.text = itemView.context.resources.
        getString(R.string.question_number,
                    position+1 , size)
           /* itemView.btnDaOne.setOnClickListener {
                listener.selectAnswer(true)
            }
            itemView.btnNetOne.setOnClickListener {
                listener.selectAnswer(false)
            }*/
    }
}

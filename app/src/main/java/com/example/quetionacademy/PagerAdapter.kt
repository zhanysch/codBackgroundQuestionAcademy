package com.example.quetionacademy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_question.view.*


// Адаптер работает с 2 viewholder (тоесть с двумя верстками)

class PagerAdapter(private val listener : PagerListener):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    //RecyclerView.ViewHolder это родит класс будет работать с множеством viewholder
    private val list = arrayListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder { // 2 viewholdera //3)
        return if (viewType == TWO_QUESTIONS ) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_question,parent,false)
            PagerViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_questionthree,parent,false)
            PagerFourButtonViewHolder(view)  // 2 viewholder
        }
    }

    fun update (list: ArrayList<String>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {  // для 2 Viewholderov исходя по позиции меняем верстку  //2)
        return if (position == 2 ) return FOUR_QUESTIONS
        else TWO_QUESTIONS
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(getItemViewType(position) == TWO_QUESTIONS ){
            (holder as PagerViewHolder).bind(list[position] , position, list.size , listener)  // position, list.size для 1/1 1/2 1/3 ...  //listener для клика
        } else {
            (holder as PagerFourButtonViewHolder).bind(list[position] , position, list.size , listener)
        }
    }

    companion object{
        const val TWO_QUESTIONS = 12  //1)
        const val FOUR_QUESTIONS = 13
    }

    override fun getItemCount() = list.size
}



class PagerViewHolder(view:View):RecyclerView.ViewHolder(view){
    fun bind(s: String, position: Int, size: Int, listener: PagerListener) {
        // "${position+1}/$size" position, list.size для выхода на экране страниц 1/1 1/2 1/3 ..
        itemView.tvcount.text = itemView.context.resources.
        getString(R.string.question_number,
                position+1 , size)
        itemView.tvQuestionFirst.text = s
         itemView.btnDaOne.setOnClickListener {
             listener.selectAnswer(true , position)
         }
        itemView.btnNetOne.setOnClickListener {
            listener.selectAnswer(false, position)
        }
    }
}


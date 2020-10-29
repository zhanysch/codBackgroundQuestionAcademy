package com.example.quetionacademy.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class PagerDecorator: RecyclerView.ItemDecoration() {  // наследуется от RecyclerView.ItemDecoration()

    ///  !!!!!!!!!! этот класс для указывания отступа в пикселях (marginstart maergin end)

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val horizontalMargin = parent.context.dpToPx(16f)  // переводит отступы в 16 пкс
        outRect.left = horizontalMargin  // отступ с правого края
        outRect.right = horizontalMargin  // отступ с левого края
    }
}
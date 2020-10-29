package com.example.quetionacademy.utils

import android.content.Context
import android.util.TypedValue

// этот класс все перегоняет в пиксели
fun Context.dpToPx(dimens: Float?): Int {
    val metrics = applicationContext.resources.displayMetrics
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dimens ?: 0f, metrics)
            .toInt()
}
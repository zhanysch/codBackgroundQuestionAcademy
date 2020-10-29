package com.example.quetionacademy

interface PagerListener {
    fun selectAnswer(answer: Boolean, position: Int)
    fun selectAnswerForbuttons(position: Int, points : Int) // points : Int это для баллов
}
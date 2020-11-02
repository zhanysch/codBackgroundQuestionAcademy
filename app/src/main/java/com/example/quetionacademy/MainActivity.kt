package com.example.quetionacademy

import android.animation.*
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.TextureView
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListeners()

       /* startvalueAnimator(view = mainText, delay = 300 , duration =  2000 ) // анимация текста подставляем методы
        startvalueAnimator(view = secondText, delay = 300 , duration =  2000 )
        startvalueAnimator(view = tvThird, delay = 300 , duration =  2000 )*/
        inputAnimation(tvThird)
    }

    private fun setupListeners() {
        btnStart.setOnClickListener {
            startActivity(Intent(this, QuestionActivity::class.java))
            overridePendingTransition(R.anim.slide_left, R.anim.slide_right)
        }
    }

    fun startObjectAnimator( // анимация текста (влево направо)
        view : View,
        delay: Long = 1000,
        duration : Long = 200,
        alphaEnd : Float = 1.0f
    ){
        val animation1 = ObjectAnimator.ofFloat(view, "translationX", -100f)
        val animation2 = ObjectAnimator.ofFloat(view, "translationX", 100f)
        val animation3 = ObjectAnimator.ofFloat(view, "translationX", 0f)

        animation1.duration = duration
        animation2.duration = duration
        animation3.duration = duration
        val animatorSet = AnimatorSet()
/*
        animatorSet.playSequentially(animation1,animation2,animation3)  // способ с остановкой текста
        animatorSet.start()*/

        animatorSet.playSequentially(animation1,animation2,animation3) // способ без остановки текста
        animatorSet.addListener(object : AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                animatorSet.start()
            }
        })
        animatorSet.start()
    }

    fun inputAnimation (view : TextView){  // анимац само напечатыван
        val text = getString(R.string.t)
        val anim = ValueAnimator.ofInt(0, text.length - 1)

        var prev = -1
        anim.addUpdateListener{
            val pos = it.animatedValue as Int // position
            if (prev != pos ){
                view.text = "${view.text}${text[pos]}"
                prev = pos
            }
        }
        anim.duration = (text.length * 100L)
        anim.start()
    }

    fun startvalueAnimator( // анимация текста 2 вариант (появление и изчезновение текста)
        view : View,
        delay: Long = 1000,
        duration : Long = 200,
        alphaEnd : Float = 1.0f
    ){
        val animation1 = ValueAnimator.ofFloat(1f, 0f, 1f)

        animation1.duration = duration
        animation1.addUpdateListener {
            view.alpha = it.animatedValue as  Float
        }
        animation1.repeatCount = 100
        animation1.start()

    }
}
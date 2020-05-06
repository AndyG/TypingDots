package com.discord.loadingdotsdemo

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils

class TypingDot @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val scaleAndFadeUpAnimation: Animation =
        AnimationUtils.loadAnimation(context, R.anim.scale_and_fade_up)

    private val scaleAndFadeDownAnimation: Animation =
        AnimationUtils.loadAnimation(context, R.anim.scale_and_fade_down)

    init {
        val backgroundDrawable = resources.getDrawable(R.drawable.circle, context.theme)
        this.background = backgroundDrawable
    }

    var onScaleDownCompleteListener: () -> Unit = { }

    fun start() {
        scaleAndFadeUpAnimation.setAnimationListener(object : AnimationListenerImpl() {
            override fun onAnimationEnd(animation: Animation?) {
                startDownAnimation()
            }
        })
        scaleAndFadeUpAnimation.fillAfter = true

        scaleAndFadeDownAnimation.setAnimationListener(object : AnimationListenerImpl() {
            override fun onAnimationEnd(animation: Animation?) {
                onScaleDownCompleteListener()
            }
        })
        scaleAndFadeDownAnimation.fillAfter = true

        startUpAnimation()
    }

    private fun startUpAnimation() {
        startAnimation(scaleAndFadeUpAnimation)
    }

    private fun startDownAnimation() {
        startAnimation(scaleAndFadeDownAnimation)
    }
}
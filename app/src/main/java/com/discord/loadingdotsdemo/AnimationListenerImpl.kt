package com.discord.loadingdotsdemo

import android.view.animation.Animation

open class AnimationListenerImpl : Animation.AnimationListener {
    override fun onAnimationRepeat(animation: Animation?) {}
    override fun onAnimationEnd(animation: Animation?) {}
    override fun onAnimationStart(animation: Animation?) {}
}
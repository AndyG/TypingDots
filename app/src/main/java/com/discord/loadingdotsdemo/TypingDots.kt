package com.discord.loadingdotsdemo

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.typing_dots_view.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TypingDots @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var startAnimationsJob: Job? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.typing_dots_view, this, true)
        dot_3.onScaleDownCompleteListener = {
            if (isAttachedToWindow) {
                start()
            }
        }
    }

    fun start() {
        startAnimationsJob = GlobalScope.launch {
            dot_1.start()
            delay(111L)
            dot_2.start()
            delay(111L)
            dot_3.start()
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        startAnimationsJob?.cancel()
    }
}
package com.dicoding.capstoneproductfix.utils

import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation

object AnimationUtil {

    fun animateClickPopUp(view: View) {
        val scaleAnimation = ScaleAnimation(
            1.0f,
            0.9f,
            1.0f,
            0.9f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        scaleAnimation.duration = 100
        scaleAnimation.fillAfter = true
        view.startAnimation(scaleAnimation)
    }

}
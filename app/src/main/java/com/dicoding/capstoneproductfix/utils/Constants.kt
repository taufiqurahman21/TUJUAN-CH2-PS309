package com.dicoding.capstoneproductfix.utils

import android.content.Context
import android.os.Handler
import android.os.Looper
import androidx.core.content.ContextCompat
import com.dicoding.capstoneproductfix.R

class Constants(context: Context) {
    val formColorGreen = ContextCompat.getColor(context, R.color.hijau)
    val formColorRedMaron = ContextCompat.getColor(context, R.color.merahmaron)
    val formColorBlue = ContextCompat.getColor(context, R.color.biru_tua)

    val handler = Handler(Looper.getMainLooper())
    val searchDelay: Long = 1000
}
package com.dicoding.capstoneproductfix.utils

import java.text.SimpleDateFormat
import java.util.Locale

object Utils {

    fun convertTimestamp(originalTimestamp: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

        val date = inputFormat.parse(originalTimestamp)
        return outputFormat.format(date!!)
    }

}
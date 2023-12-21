package com.dicoding.capstoneproductfix.data.model.dataquestion

data class Question(
    val id: String,
    val question: String,
    var selectedOptionId: Int = 0,
)


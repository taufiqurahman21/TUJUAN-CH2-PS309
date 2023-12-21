package com.dicoding.capstoneproductfix.data.model

import com.google.gson.annotations.SerializedName

data class ErrorMessageResponseRegister(
    @field:SerializedName("error")
    val error: Boolean? = null
)

data class ErrorMessageResponseLogin(
    @field:SerializedName("error")
    val error: Boolean? = null,

    val user: UserLogin?
)

data class UserLogin(
    @field:SerializedName("uid")
    val uid: String,

    @field:SerializedName("email")
    val email: String
)

data class PredictedInterestResponse(
    @field:SerializedName("predicted_interest")
    val predictedInterest: String
)

data class History(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("timestamp")
    var timestamp: String,

    @field:SerializedName("result")
    val result: String
)

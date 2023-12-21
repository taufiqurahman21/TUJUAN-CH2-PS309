package com.dicoding.capstoneproductfix.data.network.api

import com.dicoding.capstoneproductfix.data.model.ErrorMessageResponseLogin
import com.dicoding.capstoneproductfix.data.model.ErrorMessageResponseRegister
import com.dicoding.capstoneproductfix.data.model.PredictedInterestResponse
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("register")
    suspend fun register(@Body requestBody: JsonObject): ErrorMessageResponseRegister

    @POST("login")
    suspend fun login(@Body requestBody: JsonObject): ErrorMessageResponseLogin

    @POST("input-data")
    suspend fun inputdata(@Body requestBody: JsonObject): ErrorMessageResponseRegister

    @GET("get-data")
    suspend fun getData(): Response<ResponseBody>

    @POST("predict")
    suspend fun getPredictedInterest(@Body requestBody: JsonObject): PredictedInterestResponse
}
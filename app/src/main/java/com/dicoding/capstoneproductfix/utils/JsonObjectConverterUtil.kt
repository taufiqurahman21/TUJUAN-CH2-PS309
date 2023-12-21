package com.dicoding.capstoneproductfix.utils

import com.google.gson.JsonObject

object JsonObjectConverterUtil {

    fun authRequestBody(email: String, password: String): JsonObject {
        val jsonObject = JsonObject().apply {
            addProperty("email", email)
            addProperty("password", password)
        }
        return jsonObject
    }

    fun historyRequestBody(result: String): JsonObject {
        val jsonObject = JsonObject().apply {
            addProperty("result", result)
        }
        return jsonObject
    }
}
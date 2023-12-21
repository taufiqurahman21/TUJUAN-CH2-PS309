package com.dicoding.capstoneproductfix.ui.authpage.register

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dicoding.capstoneproductfix.data.network.Result
import com.dicoding.capstoneproductfix.data.network.api.ApiClient
import com.google.gson.JsonObject
import kotlinx.coroutines.launch

class RegisterViewModel(application: Application) : AndroidViewModel(application) {

    private val apiService = ApiClient.createApiServiceAuth()

    val resultRegister = MutableLiveData<Result>()

    fun getRegister(requestBody: JsonObject) {
        viewModelScope.launch {
            resultRegister.value = Result.Loading(true)
            try {
                val response = apiService.register(requestBody)
                resultRegister.value = Result.Success(response)
            } catch (e: Exception) {
                e.printStackTrace()
                resultRegister.value = Result.Error(e)
            } finally {
                resultRegister.value = Result.Loading(false)
            }
        }
    }

}
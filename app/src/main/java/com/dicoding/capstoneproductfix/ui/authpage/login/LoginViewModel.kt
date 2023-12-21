package com.dicoding.capstoneproductfix.ui.authpage.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dicoding.capstoneproductfix.data.model.UserLogin
import com.dicoding.capstoneproductfix.data.network.Result
import com.dicoding.capstoneproductfix.data.network.api.ApiClient
import com.dicoding.capstoneproductfix.data.network.repository.LoginRepository
import com.google.gson.JsonObject
import kotlinx.coroutines.launch

class LoginViewModel(
    application: Application,
    private val pref: LoginRepository
) : AndroidViewModel(application) {

    private val apiService = ApiClient.createApiServiceAuth()
    val resultLogin = MutableLiveData<Result>()

    fun getLogin(requestBody: JsonObject) {
        viewModelScope.launch {
            resultLogin.value = Result.Loading(true)
            try {
                val response = apiService.login(requestBody)
                val userLoginCheck = response.user
                if (userLoginCheck != null) {
                    initApiClientWithToken(userLoginCheck.uid)
                    saveUserLoginToDataStore(userLoginCheck)
                    saveEmailToDataStore(userLoginCheck.email)
                }
                resultLogin.value = Result.Success(response)
            } catch (e: Exception) {
                e.printStackTrace()
                resultLogin.value = Result.Error(e)
            } finally {
                resultLogin.value = Result.Loading(false)
            }
        }
    }

    private suspend fun saveUserLoginToDataStore(userLogin: UserLogin) {
        pref.saveLoginResult(userLogin)
    }

    private suspend fun saveEmailToDataStore(email: String) {
        pref.saveEmail(email)
    }

    private fun initApiClientWithToken(userID: String) {
        ApiClient.initToken(userID)
    }
}
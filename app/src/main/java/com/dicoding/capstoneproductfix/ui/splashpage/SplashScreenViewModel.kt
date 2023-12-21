package com.dicoding.capstoneproductfix.ui.splashpage

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dicoding.capstoneproductfix.data.network.repository.LoginRepository
import kotlinx.coroutines.flow.first

class SplashScreenViewModel(private val loginSave: LoginRepository) : ViewModel() {

    val token: LiveData<String?> = liveData {
        val userLogin = loginSave.getLoginResult().first()
        val token = userLogin.uid
        emit(token)
    }
}
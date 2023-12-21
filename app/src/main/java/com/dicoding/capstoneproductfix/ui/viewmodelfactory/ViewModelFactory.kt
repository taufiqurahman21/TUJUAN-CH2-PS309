package com.dicoding.capstoneproductfix.ui.viewmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.capstoneproductfix.data.network.repository.LoginRepository
import com.dicoding.capstoneproductfix.ui.authpage.login.LoginViewModel
import com.dicoding.capstoneproductfix.ui.authpage.register.RegisterViewModel
import com.dicoding.capstoneproductfix.ui.historypage.HistoryViewModel
import com.dicoding.capstoneproductfix.ui.mainpage.MainViewModel
import com.dicoding.capstoneproductfix.ui.profilepage.ProfileViewModel
import com.dicoding.capstoneproductfix.ui.questionpage.QuestionViewModel
import com.dicoding.capstoneproductfix.ui.splashpage.SplashScreenViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactoryRegister(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(application) as T
        }
        if (modelClass.isAssignableFrom(HistoryViewModel::class.java)) {
            return HistoryViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}

@Suppress("UNCHECKED_CAST")
class ViewModelFactoryLogin(
    private val application: Application,
    private val pref: LoginRepository
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(application, pref) as T
        }
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return ProfileViewModel(application, pref) as T
        }
        if (modelClass.isAssignableFrom(QuestionViewModel::class.java)) {
            return QuestionViewModel(application, pref) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}

@Suppress("UNCHECKED_CAST")
class ViewModelFactoryMain(private val pref: LoginRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SplashScreenViewModel::class.java)) {
            return SplashScreenViewModel(pref) as T
        }
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(pref) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}
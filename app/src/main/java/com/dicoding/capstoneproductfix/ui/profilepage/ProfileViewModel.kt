package com.dicoding.capstoneproductfix.ui.profilepage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.dicoding.capstoneproductfix.data.network.repository.LoginRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class ProfileViewModel(
    application: Application,
    private val pref: LoginRepository
) : AndroidViewModel(application) {

    fun clearUserData() {
        viewModelScope.launch {
            pref.clearTokenFromDataStore()
        }
    }

    val email: LiveData<String?> = liveData {
        val userLogin = pref.getEmailFromDataStore().first()
        emit(userLogin)
    }

}
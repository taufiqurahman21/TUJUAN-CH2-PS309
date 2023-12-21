package com.dicoding.capstoneproductfix.ui.mainpage

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dicoding.capstoneproductfix.data.network.repository.LoginRepository
import kotlinx.coroutines.flow.first

class MainViewModel(
    private val pref: LoginRepository
) : ViewModel() {

    val predict: LiveData<String?> = liveData {
        val userPredict = pref.getPredictFromDataStore().first()
        emit(userPredict)
    }
}
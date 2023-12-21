package com.dicoding.capstoneproductfix.ui.historypage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dicoding.capstoneproductfix.data.network.Result
import com.dicoding.capstoneproductfix.data.network.api.ApiClient
import kotlinx.coroutines.launch

class HistoryViewModel(application: Application) : AndroidViewModel(application) {
    private val apiService = ApiClient.createApiServiceHistory()
    val resultHistory = MutableLiveData<Result>()
    val resultHistory2 = MutableLiveData<String>()

    fun getHistory() {
        viewModelScope.launch {
            resultHistory.value = Result.Loading(true)
            try {
                val response = apiService.getData()

                if (response.isSuccessful) {
                    val historyData = response.body()
                    resultHistory.value = Result.Success(historyData)
                } else {
                    resultHistory.value = Result.Error(Exception("Failed to fetch data"))
                }
            } catch (e: Exception) {
                e.printStackTrace()
                resultHistory.value = Result.Error(e)
            } finally {
                resultHistory.value = Result.Loading(false)
            }
        }
    }
}

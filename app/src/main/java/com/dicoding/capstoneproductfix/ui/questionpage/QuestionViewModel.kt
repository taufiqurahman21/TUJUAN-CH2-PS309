package com.dicoding.capstoneproductfix.ui.questionpage

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dicoding.capstoneproductfix.data.network.Result
import com.dicoding.capstoneproductfix.data.network.api.ApiClient
import com.dicoding.capstoneproductfix.data.network.repository.LoginRepository
import com.google.gson.JsonObject
import kotlinx.coroutines.launch

class QuestionViewModel(
    application: Application,
    private val pref: LoginRepository
) : AndroidViewModel(application) {

    private val apiService = ApiClient.createApiServiceQuestion()
    private val apiServiceHistory = ApiClient.createApiServiceHistory()

    val resultQuestion = MutableLiveData<Result>()

    private val resultHistory = MutableLiveData<Result>()
    val resultHistory2 = MutableLiveData<String>()

    val selectedOptionsMap = mutableMapOf<String, Int>()

    fun getAnswer(requestBody: JsonObject) {
        viewModelScope.launch {
            resultQuestion.value = Result.Loading(true)
            try {
                val response = apiService.getPredictedInterest(requestBody)
                val predictedInterest = response.predictedInterest
                resultQuestion.value = Result.Success(response)
                savePredictToDataStore(predictedInterest)
                Log.d("getAnswer", "response: $response, $predictedInterest")
                resultHistory2.value = predictedInterest
            } catch (e: Exception) {
                e.printStackTrace()
                resultQuestion.value = Result.Error(e)
            } finally {
                resultQuestion.value = Result.Loading(false)
            }
        }
    }

    private suspend fun savePredictToDataStore(predict: String) {
        pref.savePredict(predict)
    }

    fun setHistory(requestBody: JsonObject) {
        viewModelScope.launch {
            resultHistory.value = Result.Loading(true)
            try {
                val response = apiServiceHistory.inputdata(requestBody)
                resultHistory.value = Result.Success(response)
            } catch (e: Exception) {
                e.printStackTrace()
                resultHistory.value = Result.Error(e)
            } finally {
                resultHistory.value = Result.Loading(false)
            }
        }
    }
}
package com.dicoding.capstoneproductfix.data.network.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.dicoding.capstoneproductfix.data.model.UserLogin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore("save_login")


class LoginRepository constructor(private val dataStore: DataStore<Preferences>) {

    private val userIdKeyDS = stringPreferencesKey("uid")
    private val emailDS = stringPreferencesKey("email")
    private val predictDS = stringPreferencesKey("predicted_interest")

    fun getLoginResult(): Flow<UserLogin> =
        dataStore.data.map { preferences ->
            val userId = preferences[userIdKeyDS] ?: ""
            val email = preferences[emailDS] ?: ""
            UserLogin(userId, email)
        }

    fun getPredictFromDataStore(): Flow<String?> = dataStore.data.map { preferences ->
        preferences[predictDS] ?: ""
    }

    suspend fun savePredict(predict: String) {
        dataStore.edit { preferences ->
            preferences[predictDS] = predict
        }
    }

    suspend fun saveLoginResult(loginResult: UserLogin) {
        dataStore.edit { preferences ->
            preferences[userIdKeyDS] = loginResult.uid
            preferences[emailDS] = loginResult.email
        }
    }

    suspend fun saveEmail(email: String) {
        dataStore.edit { preferences ->
            preferences[emailDS] = email
        }
    }

    fun getEmailFromDataStore(): Flow<String?> = dataStore.data.map { preferences ->
        preferences[emailDS] ?: ""
    }

    suspend fun clearTokenFromDataStore() {
        dataStore.edit { preferences ->
            preferences.remove(userIdKeyDS)
            preferences.remove(emailDS)
        }
    }
}
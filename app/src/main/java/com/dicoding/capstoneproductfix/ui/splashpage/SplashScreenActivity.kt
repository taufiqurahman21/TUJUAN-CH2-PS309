package com.dicoding.capstoneproductfix.ui.splashpage

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dicoding.capstoneproductfix.R
import com.dicoding.capstoneproductfix.data.network.api.ApiClient
import com.dicoding.capstoneproductfix.data.network.repository.LoginRepository
import com.dicoding.capstoneproductfix.data.network.repository.dataStore
import com.dicoding.capstoneproductfix.ui.authpage.login.LoginActivity
import com.dicoding.capstoneproductfix.ui.mainpage.MainActivity
import com.dicoding.capstoneproductfix.ui.viewmodelfactory.ViewModelFactoryMain

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var loginSave: LoginRepository
    private lateinit var viewModelFactory: ViewModelFactoryMain
    private lateinit var viewModel: SplashScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        loginSave = LoginRepository(dataStore)
        viewModelFactory = ViewModelFactoryMain(loginSave)
        viewModel = ViewModelProvider(this, viewModelFactory)[SplashScreenViewModel::class.java]

        checkToken()
    }

    private fun checkToken() {
        Handler(Looper.getMainLooper()).postDelayed({
            viewModel.token.observe(this) {
                if (!it.isNullOrEmpty()) {
                    ApiClient.initToken(it)

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    if (it != null) {
                        Log.d("TokenAPI Empty", null.toString())
                    }
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }
                finish()
            }
        }, 2000)
    }
}
package com.dicoding.capstoneproductfix.ui.mainpage

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.dicoding.capstoneproductfix.R
import com.dicoding.capstoneproductfix.data.network.repository.LoginRepository
import com.dicoding.capstoneproductfix.data.network.repository.dataStore
import com.dicoding.capstoneproductfix.databinding.ActivityMainBinding
import com.dicoding.capstoneproductfix.ui.historypage.HistoryActivity
import com.dicoding.capstoneproductfix.ui.profilepage.ProfileActivity
import com.dicoding.capstoneproductfix.ui.questionpage.QuestionActivity
import com.dicoding.capstoneproductfix.ui.viewmodelfactory.ViewModelFactoryMain
import com.dicoding.capstoneproductfix.utils.AnimationUtil

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var loginSave: LoginRepository
    private lateinit var viewModelFactory: ViewModelFactoryMain
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginSave = LoginRepository(dataStore)
        viewModelFactory = ViewModelFactoryMain(loginSave)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        binding()
    }

    @SuppressLint("SetTextI18n")
    private fun binding() {

        binding.apply {
            iconHome.setColorFilter(ContextCompat.getColor(this@MainActivity, R.color.biru_tua))
            tviconHome.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.biru_tua))
            mainTitle.isVisible = false
            tvResult.isVisible = false
            tvFinalresult.isVisible = false
            tvLine.isVisible = false
        }

        viewModel.predict.observe(this) {
            Log.d("predict", it.toString())
            if (it.isNullOrEmpty()) {
                binding.tvFinalresult.text = "Null"
            } else {
                binding.apply {
                    mainTitle.isVisible = true
                    tvResult.isVisible = true
                    tvFinalresult.isVisible = true
                    tvLine.isVisible = true
                    tvFinalresult.text = it
                }
            }
        }

        binding.iconHistory.setOnClickListener {

            AnimationUtil.animateClickPopUp(binding.iconHistory)
            AnimationUtil.animateClickPopUp(binding.tviconHistory)

            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, HistoryActivity::class.java)
                startActivity(intent)
            }, 100)
        }

        binding.iconProfile.setOnClickListener {

            AnimationUtil.animateClickPopUp(binding.iconProfile)
            AnimationUtil.animateClickPopUp(binding.tviconProfile)

            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }, 100)
        }

        binding.iconHome.setOnClickListener {

            AnimationUtil.animateClickPopUp(binding.iconHome)
            AnimationUtil.animateClickPopUp(binding.tviconHome)
        }

        binding.buttonMulai.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}
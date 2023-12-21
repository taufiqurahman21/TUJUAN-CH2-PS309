package com.dicoding.capstoneproductfix.ui.profilepage

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.dicoding.capstoneproductfix.R
import com.dicoding.capstoneproductfix.data.network.repository.LoginRepository
import com.dicoding.capstoneproductfix.data.network.repository.dataStore
import com.dicoding.capstoneproductfix.databinding.ActivityProfileBinding
import com.dicoding.capstoneproductfix.ui.historypage.HistoryActivity
import com.dicoding.capstoneproductfix.ui.mainpage.MainActivity
import com.dicoding.capstoneproductfix.ui.viewmodelfactory.ViewModelFactoryLogin
import com.dicoding.capstoneproductfix.utils.AnimationUtil
import com.dicoding.capstoneproductfix.utils.DialogAlertUtil

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var loginSave: LoginRepository
    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var viewModelFactory: ViewModelFactoryLogin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginSave = LoginRepository(dataStore)
        viewModelFactory = ViewModelFactoryLogin(application, loginSave)
        profileViewModel = ViewModelProvider(this, viewModelFactory)[ProfileViewModel::class.java]

        binding()
    }

    @SuppressLint("SetTextI18n")
    private fun binding() {

        profileViewModel.email.observe(this) {
            if (it.isNullOrEmpty()) {
                binding.tvEmail.text = "Null"
            } else {
                binding.tvEmail.text = it
            }
        }

        binding.apply {
            iconProfile.setColorFilter(
                ContextCompat.getColor(
                    this@ProfileActivity,
                    R.color.biru_tua
                )
            )
            tviconProfile.setTextColor(
                ContextCompat.getColor(
                    this@ProfileActivity,
                    R.color.biru_tua
                )
            )
        }

        binding.iconHistory.setOnClickListener {

            AnimationUtil.animateClickPopUp(binding.iconHistory)
            AnimationUtil.animateClickPopUp(binding.tviconHistory)

            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, HistoryActivity::class.java)
                startActivity(intent)
                finish()
            }, 100)
        }

        binding.iconHome.setOnClickListener {

            AnimationUtil.animateClickPopUp(binding.iconHome)
            AnimationUtil.animateClickPopUp(binding.tviconHome)

            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 100)
        }

        binding.iconProfile.setOnClickListener {

            AnimationUtil.animateClickPopUp(binding.iconProfile)
            AnimationUtil.animateClickPopUp(binding.tviconProfile)
        }

        binding.IMIconBack.setOnClickListener {

            AnimationUtil.animateClickPopUp(binding.IMIconBack)

            Handler(Looper.getMainLooper()).postDelayed({
                onBackPressedDispatcher.onBackPressed()
            }, 100)
        }

        binding.IMIconLogout.setOnClickListener {

            AnimationUtil.animateClickPopUp(binding.IMIconLogout)

            Handler(Looper.getMainLooper()).postDelayed({
                DialogAlertUtil.showDialogAlterLogout(this)
                profileViewModel.clearUserData()
            }, 100)
        }
    }
}
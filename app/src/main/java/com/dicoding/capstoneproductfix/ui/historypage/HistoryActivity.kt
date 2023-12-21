package com.dicoding.capstoneproductfix.ui.historypage

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.capstoneproductfix.R
import com.dicoding.capstoneproductfix.data.model.History
import com.dicoding.capstoneproductfix.data.network.Result
import com.dicoding.capstoneproductfix.databinding.ActivityHistoryBinding
import com.dicoding.capstoneproductfix.ui.mainpage.MainActivity
import com.dicoding.capstoneproductfix.ui.profilepage.ProfileActivity
import com.dicoding.capstoneproductfix.ui.viewmodelfactory.ViewModelFactoryRegister
import com.dicoding.capstoneproductfix.utils.AnimationUtil
import com.dicoding.capstoneproductfix.utils.Utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding
    private lateinit var viewModel: HistoryViewModel
    private lateinit var viewModelFactory: ViewModelFactoryRegister

    private val adapter by lazy {
        AdapterHistory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModelFactory = ViewModelFactoryRegister(application)
        viewModel = ViewModelProvider(this, viewModelFactory)[HistoryViewModel::class.java]
        binding.rvListQuestion.layoutManager = LinearLayoutManager(this)

        binding()
        historyNew()
    }

    private fun binding() {

        binding.apply {
            iconHistory.setColorFilter(
                ContextCompat.getColor(
                    this@HistoryActivity,
                    R.color.biru_tua
                )
            )
            tviconHistory.setTextColor(
                ContextCompat.getColor(
                    this@HistoryActivity,
                    R.color.biru_tua
                )
            )
            rvListQuestion.adapter = adapter
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

        binding.iconHistory.setOnClickListener {

            AnimationUtil.animateClickPopUp(binding.iconHistory)
            AnimationUtil.animateClickPopUp(binding.tviconHistory)
        }

        binding.iconProfile.setOnClickListener {

            AnimationUtil.animateClickPopUp(binding.iconProfile)
            AnimationUtil.animateClickPopUp(binding.tviconProfile)

            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                finish()
            }, 100)
        }

        binding.IMIconBack.setOnClickListener {
            AnimationUtil.animateClickPopUp(binding.IMIconBack)

            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, HistoryActivity::class.java)
                startActivity(intent)
                finish()
            }, 100)
        }
    }

    private fun historyNew() {
        viewModel.resultHistory.observe(this) { result ->
            when (result) {
                is Result.Success<*> -> {
                    val responseBody = result.data as? ResponseBody
                    val jsonString = responseBody?.string()

                    if (!jsonString.isNullOrEmpty()) {
                        val historyList = Gson().fromJson<List<History>>(
                            jsonString,
                            object : TypeToken<List<History>>() {}.type
                        )

                        for (history in historyList) {
                            history.timestamp = Utils.convertTimestamp(history.timestamp)
                        }

                        adapter.submitList(historyList)
                        Log.d("History", "Parsed JSON response: $historyList")
                    }
                }

                is Result.Error -> {

                }

                is Result.Loading -> {
                    binding.progressBar.isVisible = result.isLoading
                }
            }
        }
        viewModel.getHistory()
    }


}
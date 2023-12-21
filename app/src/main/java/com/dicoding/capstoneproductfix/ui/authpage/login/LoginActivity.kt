package com.dicoding.capstoneproductfix.ui.authpage.login

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.dicoding.capstoneproductfix.R
import com.dicoding.capstoneproductfix.data.network.Result
import com.dicoding.capstoneproductfix.data.network.repository.LoginRepository
import com.dicoding.capstoneproductfix.data.network.repository.dataStore
import com.dicoding.capstoneproductfix.databinding.ActivityLoginBinding
import com.dicoding.capstoneproductfix.ui.authpage.register.RegisterActivity
import com.dicoding.capstoneproductfix.ui.customview.PasswordCustomView
import com.dicoding.capstoneproductfix.ui.viewmodelfactory.ViewModelFactoryLogin
import com.dicoding.capstoneproductfix.utils.AnimationUtil
import com.dicoding.capstoneproductfix.utils.Constants
import com.dicoding.capstoneproductfix.utils.DialogAlertUtil
import com.dicoding.capstoneproductfix.utils.JsonObjectConverterUtil
import com.google.android.material.textfield.TextInputLayout
import com.google.gson.JsonObject
import java.util.Locale

@Suppress("DEPRECATION")
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var myEditText: PasswordCustomView
    private lateinit var constants: Constants
    private lateinit var loginSave: LoginRepository
    private lateinit var viewModelFactory: ViewModelFactoryLogin
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginSave = LoginRepository(dataStore)
        constants = Constants(this)
        viewModelFactory = ViewModelFactoryLogin(application, loginSave)
        loginViewModel = ViewModelProvider(this, viewModelFactory)[LoginViewModel::class.java]

        binding()
        inputCheck()
        loginAccount()
    }

    private fun binding() {

        binding.apply {
            formPassword.isVisible = false
            buttonloginkanan.isEnabled = false
            progressBar.isVisible = false
        }

        binding.TVSignup.setOnClickListener {

            AnimationUtil.animateClickPopUp(binding.TVSignup)

            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }, 100)
        }
    }

    private fun inputCheck() {
        myEditText = findViewById(R.id.editText_formpassword)
        val editTextLayoutPassword: TextInputLayout = findViewById(R.id.form_password)
        myEditText.setTextInputLayout(editTextLayoutPassword)

        fun checkEmailUsername(user: String) {
            val validEmailRegex = Regex(getString(R.string.a_za_z0_9_a_za_z0_9_a_za_z_2_4))

            if (user.isNotEmpty()) {
                if (user.isNotEmpty() && !(user.matches(validEmailRegex))) {
                    binding.apply {
                        formEmailusername.helperText = resources.getString(R.string.EmailInvalid)
                        formEmailusername.boxStrokeColor = constants.formColorRedMaron
                    }
                } else {
                    binding.apply {
                        editTextLayoutPassword.isVisible = true
                        buttonloginkanan.isEnabled = true
                        formEmailusername.isEnabled = false
                        formEmailusername.boxStrokeColor = constants.formColorGreen
                        formEmailusername.helperText = null
                    }
                }
            } else {
                binding.apply {
                    formEmailusername.helperText = resources.getString(R.string.e_mail_kosong)
                    formEmailusername.boxStrokeColor = constants.formColorRedMaron
                }
            }
        }
        binding.editTextFormemailusername.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                constants.handler.removeCallbacksAndMessages(null)
                constants.handler.postDelayed({
                    checkEmailUsername(
                        binding.editTextFormemailusername.text.toString()
                    )
                }, constants.searchDelay)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    private fun loginAccount() {

        fun loginNew(requestBody: JsonObject) {
            loginViewModel.resultLogin.observe(this) { result ->
                when (result) {
                    is Result.Success<*> -> {
                        DialogAlertUtil.showDialogAlterLogin(this, true)
                        binding.buttonloginkanan.isEnabled = true
                    }

                    is Result.Error -> {
                        DialogAlertUtil.showDialogAlterLogin(this, false)
                    }

                    is Result.Loading -> {
                        binding.apply {
                            progressBar.isVisible = result.isLoading
                            buttonloginkanan.isEnabled = false
                        }
                    }
                }
            }
            loginViewModel.getLogin(requestBody)
        }

        binding.buttonloginkanan.setOnClickListener {
            val emailInput =
                binding.editTextFormemailusername.text.toString().trim().lowercase(Locale.ROOT)
            val newPasswordInput = binding.editTextFormpassword.text.toString().trim()
            val check = emailInput.isNotEmpty() && newPasswordInput.isNotEmpty()

            if (check) {
                loginNew(JsonObjectConverterUtil.authRequestBody(emailInput, newPasswordInput))
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (!binding.editTextFormemailusername.isEnabled) {
            binding.apply {
                buttonloginkanan.isEnabled = false
                editTextFormemailusername.isEnabled = true
                formEmailusername.isEnabled = true
                formEmailusername.boxStrokeColor = constants.formColorBlue
                formPassword.boxStrokeColor = constants.formColorBlue
                formPassword.isVisible = false
                editTextFormpassword.text = null
                formPassword.helperText = resources.getString(R.string.enter_password)
                formPassword.setHelperTextColor(ColorStateList.valueOf(getColor(R.color.biru_tua)))
                formPassword.counterTextColor = ColorStateList.valueOf(getColor(R.color.biru_tua))
                formPassword.boxStrokeColor = constants.formColorBlue
            }
            return
        } else {
            super.onBackPressed()
            return
        }
    }
}
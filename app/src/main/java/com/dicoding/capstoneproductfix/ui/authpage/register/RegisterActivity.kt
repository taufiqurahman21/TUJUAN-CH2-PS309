package com.dicoding.capstoneproductfix.ui.authpage.register

import android.content.res.ColorStateList
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.dicoding.capstoneproductfix.R
import com.dicoding.capstoneproductfix.data.network.Result
import com.dicoding.capstoneproductfix.databinding.ActivityRegisterBinding
import com.dicoding.capstoneproductfix.ui.customview.PasswordCustomView
import com.dicoding.capstoneproductfix.ui.viewmodelfactory.ViewModelFactoryRegister
import com.dicoding.capstoneproductfix.utils.Constants
import com.dicoding.capstoneproductfix.utils.DialogAlertUtil
import com.dicoding.capstoneproductfix.utils.JsonObjectConverterUtil
import com.google.android.material.textfield.TextInputLayout
import com.google.gson.JsonObject
import java.util.Locale

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var constants: Constants
    private lateinit var myEditText: PasswordCustomView
    private lateinit var viewModel: RegisterViewModel
    private lateinit var viewModelFactory: ViewModelFactoryRegister

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        constants = Constants(this)
        viewModelFactory = ViewModelFactoryRegister(application)
        viewModel = ViewModelProvider(this, viewModelFactory)[RegisterViewModel::class.java]

        binding()
        inputCheck()
        userRegister()
    }

    private fun binding() {

        binding.apply {
            formPassword.isVisible = false
            buttonloginkanan.isEnabled = false
            progressBar.isVisible = false
        }

        binding.buttonloginkiri.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun inputCheck() {
        myEditText = findViewById(R.id.editText_formpassword)
        val editTextLayoutPassword: TextInputLayout = findViewById(R.id.form_password)
        myEditText.setTextInputLayout(editTextLayoutPassword)

        fun searchAndNotifyEmail(textEmail: String) {
            val validEmailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$")
            val colorStateList =
                ColorStateList.valueOf(ContextCompat.getColor(this, R.color.biru_tua))

            if (textEmail.isNotEmpty()) {
                if (!textEmail.matches(validEmailRegex)) {
                    binding.apply {
                        formEmail.boxStrokeColor = constants.formColorRedMaron
                        formPassword.isVisible = false
                        buttonloginkanan.isEnabled = false
                        editTextFormpassword.text = null
                        formPassword.helperText =
                            resources.getString(R.string.enter_password)
                    }
                    when {
                        !textEmail.matches(validEmailRegex) -> binding.formEmail.helperText =
                            resources.getString(R.string.EmailInvalid)
                    }
                } else {
                    binding.apply {
                        formEmail.boxStrokeColor = constants.formColorBlue
                        formEmail.helperText = null
                        formPassword.isVisible = true
                        buttonloginkanan.isEnabled = true
                        formPassword.boxStrokeColor = constants.formColorBlue
                        formPassword.setHelperTextColor(ColorStateList.valueOf(constants.formColorBlue))
                        formPassword.counterTextColor = colorStateList
                    }
                }
            }
        }

        binding.editTextFormemail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                constants.handler.removeCallbacksAndMessages(null)
                constants.handler.postDelayed({
                    searchAndNotifyEmail(
                        binding.editTextFormemail.text.toString()
                    )

                }, constants.searchDelay)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    private fun userRegister() {

        fun registerNew(requestBody: JsonObject) {
            viewModel.resultRegister.observe(this) { result ->
                when (result) {
                    is Result.Success<*> -> {
                        DialogAlertUtil.showDialogAlterRegister(this, true)
                        binding.buttonloginkanan.isEnabled = true
                    }

                    is Result.Error -> {
                        DialogAlertUtil.showDialogAlterRegister(this, false)
                    }

                    is Result.Loading -> {
                        binding.apply {
                            progressBar.isVisible = result.isLoading
                            buttonloginkanan.isEnabled = false
                        }
                    }
                }
            }
            viewModel.getRegister(requestBody)
        }

        binding.buttonloginkanan.setOnClickListener {
            val emailInput = binding.editTextFormemail.text.toString().trim().lowercase(Locale.ROOT)
            val newPasswordInput = binding.editTextFormpassword.text.toString().trim()
            val check = emailInput.isNotEmpty() && newPasswordInput.isNotEmpty()

            if (check) {
                registerNew(JsonObjectConverterUtil.authRequestBody(emailInput, newPasswordInput))
            }
        }
    }
}

package com.dicoding.capstoneproductfix.ui.customview

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.dicoding.capstoneproductfix.R
import com.google.android.material.textfield.TextInputLayout

@SuppressLint("ViewConstructor")
class PasswordCustomView : AppCompatEditText {

    private var charLength = 0
    private var textInputLayout: TextInputLayout? = null

    private fun init() {
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // do nothing
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                charLength = s.length

                val helperText = when {
                    charLength < 8 -> {
                        textInputLayout?.setHelperTextColor(
                            ColorStateList.valueOf(
                                ContextCompat.getColor(
                                    context,
                                    R.color.merahmaron
                                )
                            )
                        )
                        val colorStateList = ColorStateList.valueOf(
                            ContextCompat.getColor(
                                context,
                                R.color.merahmaron
                            )
                        )
                        textInputLayout?.counterTextColor = colorStateList
                        textInputLayout?.boxStrokeColor =
                            ContextCompat.getColor(context, R.color.merahmaron)
                        context.getString(R.string.PasswordKurangPanjang)
                    }

                    charLength > 20 -> {
                        textInputLayout?.setHelperTextColor(
                            ColorStateList.valueOf(
                                ContextCompat.getColor(
                                    context,
                                    R.color.merahmaron
                                )
                            )
                        )
                        textInputLayout?.boxStrokeColor =
                            ContextCompat.getColor(context, R.color.merahmaron)
                        context.getString(R.string.PasswordTerlaluPanjang)
                    }

                    else -> {
                        textInputLayout?.setHelperTextColor(
                            ColorStateList.valueOf(
                                ContextCompat.getColor(
                                    context,
                                    R.color.biru_tua
                                )
                            )
                        )
                        val colorStateList = ColorStateList.valueOf(
                            ContextCompat.getColor(
                                context,
                                R.color.biru_tua
                            )
                        )
                        textInputLayout?.counterTextColor = colorStateList
                        textInputLayout?.boxStrokeColor =
                            ContextCompat.getColor(context, R.color.biru_tua)
                        context.getString(R.string.enter_password)
                    }
                }

                textInputLayout?.helperText = helperText
            }


            override fun afterTextChanged(s: Editable?) {
                // do nothing
            }
        })
    }

    fun setTextInputLayout(textInputLayout: TextInputLayout) {
        this.textInputLayout = textInputLayout
    }

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

}

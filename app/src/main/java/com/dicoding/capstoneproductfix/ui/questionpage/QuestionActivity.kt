package com.dicoding.capstoneproductfix.ui.questionpage

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.capstoneproductfix.R
import com.dicoding.capstoneproductfix.data.model.dataquestion.ListQuestion
import com.dicoding.capstoneproductfix.data.network.Result
import com.dicoding.capstoneproductfix.data.network.repository.LoginRepository
import com.dicoding.capstoneproductfix.data.network.repository.dataStore
import com.dicoding.capstoneproductfix.databinding.ActivityQuestionBinding
import com.dicoding.capstoneproductfix.databinding.ItemDialogalertBinding
import com.dicoding.capstoneproductfix.ui.viewmodelfactory.ViewModelFactoryLogin
import com.dicoding.capstoneproductfix.utils.DialogAlertUtil
import com.dicoding.capstoneproductfix.utils.JsonObjectConverterUtil.historyRequestBody
import com.google.gson.JsonObject
import kotlinx.coroutines.launch

class QuestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionBinding
    private lateinit var viewModel: QuestionViewModel
    private lateinit var viewModelFactory: ViewModelFactoryLogin
    private lateinit var loginSave: LoginRepository
    private var currentPosition = 0
    private var currentPosition2 = 1

    private val adapter by lazy {
        AdapterQuestion()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginSave = LoginRepository(dataStore)
        binding.rvListQuestion.layoutManager = LinearLayoutManager(this)
        viewModelFactory = ViewModelFactoryLogin(application, loginSave)
        viewModel = ViewModelProvider(this, viewModelFactory)[QuestionViewModel::class.java]

        binding()
        userQuestion()
        pageShow()
    }

    private fun binding() {
        binding.apply {
            rvListQuestion.adapter = adapter
            rvListQuestion.setHasFixedSize(true)
            progressBar.isVisible = false
        }
    }

    private fun pageShow() {
        val beginPositionPriv = (currentPosition2 - 1) * 5
        val endPositionPriv = currentPosition2 * 5
        adapter.submitList(ListQuestion.question.subList(beginPositionPriv, endPositionPriv))
        Log.d("rangePageShow", "beginPosition: $beginPositionPriv, endPosition: $endPositionPriv")
    }

    private fun userQuestion() {

        fun questionNew(requestBody: JsonObject) {
            viewModel.resultQuestion.observe(this) { result ->
                when (result) {
                    is Result.Success<*> -> {
                        DialogAlertUtil.showDialogAlterQuestion(this)
                        viewModel.resultHistory2.observe(this) { prediction ->
                            Log.d("predictInside", prediction.toString())
                            if (!prediction.isNullOrEmpty()) {
                                val requestBodyHisotry = historyRequestBody(prediction.toString())
                                lifecycleScope.launch {
                                    viewModel.setHistory(requestBodyHisotry)
                                }
                            }
                        }
                    }

                    is Result.Error -> {
                        DialogAlertUtil.showDialogAlterError(this)
                    }

                    is Result.Loading -> {
                        binding.progressBar.isVisible = result.isLoading
                    }
                }
            }

            viewModel.getAnswer(requestBody)
        }

        binding.buttonloginkanan.setOnClickListener {
            val check = currentPosition * 5
            if (check >= 70) {
                val userAnswers = JsonObject()
                for ((categoryKey, selectedOptionId) in viewModel.selectedOptionsMap) {
                    userAnswers.addProperty(categoryKey, selectedOptionId)
                }
                questionNew(userAnswers)
            } else {
                Handler(Looper.getMainLooper()).postDelayed({
                    showDialogAlterQuestionNext(this)
                }, 100)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun showDialogAlterQuestionNext(context: Context) {
        val inflater = LayoutInflater.from(context)
        val bindingCs = ItemDialogalertBinding.inflate(inflater)
        val dialogView = bindingCs.root
        val dialogBuilder = androidx.appcompat.app.AlertDialog.Builder(context)
        dialogBuilder.setView(dialogView)
        val dialog = dialogBuilder.create()

        bindingCs.apply {
            dialogTitle.text = context.getString(R.string.yakin_question2)
            selanjutnyaButton2.text = context.getString(R.string.kembali)
            selanjutnyaButton2.isGone = false
            selanjutnyaButton.text = context.getString(R.string.YA)
            ImageView.setImageResource(0)
            ImageView.setImageResource(R.drawable.tandatanya)
        }

        bindingCs.selanjutnyaButton.setOnClickListener {
            val beginPosition = (currentPosition * 5) + 1
            val endPosition = beginPosition + 4

            if (beginPosition <= ListQuestion.question.size) {
                Log.d("rangeSaveIndeks", "beginPosition: $beginPosition, endPosition: $endPosition")

                val questionsOnCurrentPage = ListQuestion.question.subList(
                    maxOf(beginPosition - 1, 0),
                    minOf(endPosition, ListQuestion.question.size)
                )

                var allQuestionsAnswered = false

                for (i in questionsOnCurrentPage.indices) {
                    val question = questionsOnCurrentPage[i]
                    val viewHolder =
                        binding.rvListQuestion.findViewHolderForAdapterPosition(i) as? AdapterQuestion.ViewHolder

                    viewHolder?.let {
                        question.selectedOptionId = when {
                            it.binding.radioButton1.isChecked -> 1
                            it.binding.radioButton2.isChecked -> 2
                            it.binding.radioButton3.isChecked -> 3
                            it.binding.radioButton4.isChecked -> 4
                            it.binding.radioButton5.isChecked -> 5
                            else -> 0
                        }

                        it.binding.radioGroup.clearCheck()

                        if (question.selectedOptionId == 0) {
                            allQuestionsAnswered = true
                        }

                        val categoryKey = question.id
                        viewModel.selectedOptionsMap[categoryKey] = question.selectedOptionId
                    }
                }

                if (allQuestionsAnswered) {
                    DialogAlertUtil.showDialogAlterError(this)
                    dialog.dismiss()
                } else {
                    Log.d("Angka Awal", "currentPosition: $currentPosition2")
                    currentPosition++
                    currentPosition2++
                    Log.d("Angka Setelah", "currentPosition: $currentPosition2")
                    val beginPositionPriv = (currentPosition2 - 1) * 5
                    val endPositionPriv = currentPosition2 * 5

                    val check = endPosition == 70

                    if (!check) {
                        adapter.submitList(
                            ListQuestion.question.subList(
                                beginPositionPriv,
                                endPositionPriv
                            )
                        )
                    } else {
                        currentPosition2 = 1
                        adapter.submitList(emptyList())
                        binding.buttonloginkanan.text = getString(R.string.Selesai)
                        DialogAlertUtil.showDialogAlterQuestionSelesai(this)
                        dialog.dismiss()
                    }

                    Log.d(
                        "rangePageShow2",
                        "beginPosition: $beginPositionPriv, endPosition: $endPositionPriv"
                    )
                    Log.d("Selected Options Map: ", viewModel.selectedOptionsMap.toString())
                    dialog.dismiss()
                }
            }
        }

        bindingCs.selanjutnyaButton2.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    override fun onResume() {
        super.onResume()
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (currentPosition >= 0) {
                    Handler(Looper.getMainLooper()).postDelayed({
                        DialogAlertUtil.showDialogAlterQuestionBack(this@QuestionActivity)
                    }, 100)
                } else {
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)
    }
}
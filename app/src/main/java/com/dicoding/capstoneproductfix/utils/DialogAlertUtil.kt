package com.dicoding.capstoneproductfix.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import androidx.core.view.isGone
import com.dicoding.capstoneproductfix.R
import com.dicoding.capstoneproductfix.databinding.ItemDialogalertBinding
import com.dicoding.capstoneproductfix.ui.authpage.login.LoginActivity
import com.dicoding.capstoneproductfix.ui.authpage.register.RegisterActivity
import com.dicoding.capstoneproductfix.ui.mainpage.MainActivity


object DialogAlertUtil {

    fun showDialogAlterLogin(context: Context, loginSuccess: Boolean) {
        val inflater = LayoutInflater.from(context)
        val bindingCs = ItemDialogalertBinding.inflate(inflater)
        val dialogView = bindingCs.root
        val dialogBuilder = androidx.appcompat.app.AlertDialog.Builder(context)
        dialogBuilder.setView(dialogView)
        val dialog = dialogBuilder.create()

        if (loginSuccess) {
            bindingCs.apply {
                dialogTitle.text = context.getString(R.string.login_succes)
                selanjutnyaButton.text = context.getString(R.string.lanjutkan)
                ImageView.setImageResource(R.drawable.centanghijau)
            }
            bindingCs.selanjutnyaButton.setOnClickListener {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                (context as Activity).finishAffinity()
                dialog.dismiss()
            }
        } else {
            bindingCs.apply {
                dialogTitle.text = context.getString(R.string.logingagal)
                selanjutnyaButton.text = context.getString(R.string.kembali)
                ImageView.setImageResource(R.drawable.centangmerah)
            }
            bindingCs.selanjutnyaButton.setOnClickListener {
                val intent = Intent(context, LoginActivity::class.java)
                context.startActivity(intent)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                dialog.dismiss()
            }
        }
        dialog.show()
    }

    fun showDialogAlterRegister(context: Context, loginSuccess: Boolean) {
        val inflater = LayoutInflater.from(context)
        val bindingCs = ItemDialogalertBinding.inflate(inflater)
        val dialogView = bindingCs.root
        val dialogBuilder = androidx.appcompat.app.AlertDialog.Builder(context)
        dialogBuilder.setView(dialogView)
        val dialog = dialogBuilder.create()

        if (loginSuccess) {
            bindingCs.apply {
                dialogTitle.text = context.getString(R.string.daftarakunberhasil)
                ImageView.setImageResource(R.drawable.centanghijau)
                selanjutnyaButton.text = context.getString(R.string.lanjutkan)
            }
            bindingCs.selanjutnyaButton.setOnClickListener {
                val intent = Intent(context, LoginActivity::class.java)
                context.startActivity(intent)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                dialog.dismiss()
            }
        } else {
            bindingCs.apply {
                dialogTitle.text = context.getString(R.string.daftarakungagal)
                ImageView.setImageResource(R.drawable.centangmerah)
                selanjutnyaButton.text = context.getString(R.string.kembali)
            }
            bindingCs.selanjutnyaButton.setOnClickListener {
                val intent = Intent(context, RegisterActivity::class.java)
                context.startActivity(intent)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                (context as Activity).finish()
                dialog.dismiss()
            }
        }
        dialog.show()
    }

    fun showDialogAlterLogout(context: Context) {
        val inflater = LayoutInflater.from(context)
        val bindingCs = ItemDialogalertBinding.inflate(inflater)
        val dialogView = bindingCs.root
        val dialogBuilder = androidx.appcompat.app.AlertDialog.Builder(context)
        dialogBuilder.setView(dialogView)
        val dialog = dialogBuilder.create()

        bindingCs.apply {
            dialogTitle.text = context.getString(R.string.ingin_logout)
            selanjutnyaButton2.text = context.getString(R.string.kembali)
            selanjutnyaButton2.isGone = false
            selanjutnyaButton.text = context.getString(R.string.YA)
            ImageView.setImageResource(0)
            ImageView.setImageResource(R.drawable.tandatanya)
        }

        bindingCs.selanjutnyaButton.setOnClickListener {
            val intent = Intent(context, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            context.startActivity(intent)
            (context as Activity).finishAffinity()
            dialog.dismiss()
        }



        bindingCs.selanjutnyaButton2.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    fun showDialogAlterQuestion(context: Context) {
        val inflater = LayoutInflater.from(context)
        val bindingCs = ItemDialogalertBinding.inflate(inflater)
        val dialogView = bindingCs.root
        val dialogBuilder = androidx.appcompat.app.AlertDialog.Builder(context)
        dialogBuilder.setView(dialogView)
        val dialog = dialogBuilder.create()

        bindingCs.apply {
            dialogTitle.text = context.getString(R.string.selesai)
            selanjutnyaButton2.text = context.getString(R.string.kembali)
            selanjutnyaButton2.isGone = true
            selanjutnyaButton.text = context.getString(R.string.YA)
            ImageView.setImageResource(0)
            ImageView.setImageResource(R.drawable.centanghijau)
        }

        bindingCs.selanjutnyaButton.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            context.startActivity(intent)
            dialog.dismiss()
        }

        bindingCs.selanjutnyaButton2.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    fun showDialogAlterQuestionSelesai(context: Context) {
        val inflater = LayoutInflater.from(context)
        val bindingCs = ItemDialogalertBinding.inflate(inflater)
        val dialogView = bindingCs.root
        val dialogBuilder = androidx.appcompat.app.AlertDialog.Builder(context)
        dialogBuilder.setView(dialogView)
        val dialog = dialogBuilder.create()

        bindingCs.apply {
            dialogTitle.text = context.getString(R.string.tahapakhir)
            selanjutnyaButton.text = context.getString(R.string.lanjutkan)
            ImageView.setImageResource(0)
            ImageView.setImageResource(R.drawable.happy)
        }

        bindingCs.selanjutnyaButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    fun showDialogAlterQuestionBack(context: Context) {
        val inflater = LayoutInflater.from(context)
        val bindingCs = ItemDialogalertBinding.inflate(inflater)
        val dialogView = bindingCs.root
        val dialogBuilder = androidx.appcompat.app.AlertDialog.Builder(context)
        dialogBuilder.setView(dialogView)
        val dialog = dialogBuilder.create()

        bindingCs.apply {
            dialogTitle.text = context.getString(R.string.question_back)
            selanjutnyaButton2.text = context.getString(R.string.kembali)
            selanjutnyaButton2.isGone = false
            selanjutnyaButton.text = context.getString(R.string.tetap)
            ImageView.setImageResource(0)
            ImageView.setImageResource(R.drawable.tandatanya)
        }

        bindingCs.selanjutnyaButton.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            context.startActivity(intent)
            dialog.dismiss()
        }

        bindingCs.selanjutnyaButton2.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    fun showDialogAlterError(context: Context) {
        val inflater = LayoutInflater.from(context)
        val bindingCs = ItemDialogalertBinding.inflate(inflater)
        val dialogView = bindingCs.root
        val dialogBuilder = androidx.appcompat.app.AlertDialog.Builder(context)
        dialogBuilder.setView(dialogView)
        val dialog = dialogBuilder.create()

        bindingCs.apply {
            dialogTitle.text = context.getString(R.string.radiobutton_empty)
            selanjutnyaButton.text = context.getString(R.string.kembali)
            ImageView.setImageResource(R.drawable.centangmerah)
        }

        bindingCs.selanjutnyaButton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}
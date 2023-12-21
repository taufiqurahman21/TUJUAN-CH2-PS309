package com.dicoding.capstoneproductfix.ui.questionpage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.capstoneproductfix.data.model.dataquestion.Question
import com.dicoding.capstoneproductfix.databinding.ItemQuestionBinding

class AdapterQuestion : ListAdapter<Question, AdapterQuestion.ViewHolder>(DiffCallback) {

    class ViewHolder(val binding: ItemQuestionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(question: Question) {
            binding.mainTitle.text = question.question

            binding.radioButton1.isChecked = false
            binding.radioButton2.isChecked = false
            binding.radioButton3.isChecked = false
            binding.radioButton4.isChecked = false
            binding.radioButton5.isChecked = false
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemQuestionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val question = getItem(position)
        holder.bind(question)
    }

    companion object {
        val DiffCallback = object : DiffUtil.ItemCallback<Question>() {
            override fun areItemsTheSame(oldItem: Question, newItem: Question): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Question, newItem: Question): Boolean {
                return oldItem == newItem
            }
        }
    }
}


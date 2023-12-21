package com.dicoding.capstoneproductfix.ui.historypage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.capstoneproductfix.data.model.History
import com.dicoding.capstoneproductfix.databinding.ItemOutputBinding

class AdapterHistory : ListAdapter<History, AdapterHistory.ViewHolder>(DiffCallback) {

    class ViewHolder(val binding: ItemOutputBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(history: History) {
            binding.apply {
                tvFinalresult.text = history.result
                tvId.text = history.id.toString()
                tvTime.text = history.timestamp
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemOutputBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val history = getItem(position)
        holder.bind(history)
    }

    companion object {
        val DiffCallback = object : DiffUtil.ItemCallback<History>() {
            override fun areItemsTheSame(oldItem: History, newItem: History): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: History, newItem: History): Boolean {
                return oldItem == newItem
            }
        }
    }
}
package com.pisolutions.accenture_eurobank.database

import androidx.recyclerview.widget.RecyclerView
import com.pisolutions.accenture_eurobank.databinding.HolderDatabaseRowBinding

class DatabaseListViewHolder(val binding: HolderDatabaseRowBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: UserEntity) {
        binding.txt.text = data.toString()
    }
}
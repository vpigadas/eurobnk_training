package com.pisolutions.accenture_eurobank.listview

import androidx.recyclerview.widget.RecyclerView
import com.pisolutions.accenture_eurobank.databinding.HolderRecyclerViewBinding

class MyRecyclerViewHolder(val binding: HolderRecyclerViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(data: String) {
        binding.holderTitle.text = data
    }
}
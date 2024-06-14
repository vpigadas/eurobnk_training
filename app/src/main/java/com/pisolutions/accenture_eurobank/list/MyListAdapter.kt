package com.pisolutions.accenture_eurobank.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pisolutions.accenture_eurobank.databinding.HolderRecyclerViewBinding

class MyListAdapter(data: List<String>) : RecyclerView.Adapter<MyListViewHolder>() {

    private val dataList: List<String> = data
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyListViewHolder {
        val binding =
            HolderRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyListViewHolder(binding)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: MyListViewHolder, position: Int) {
        holder.binding.holderTitle.text =
            "position -> ".plus(position).plus(" value -> ").plus(dataList.get(position))
    }

}
package com.pisolutions.accenture_eurobank.listview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pisolutions.accenture_eurobank.databinding.HolderRecyclerViewBinding

class MyRecyclerViewAdapter(
    private val arrayData: List<String>
) : RecyclerView.Adapter<MyRecyclerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecyclerViewHolder {
        val view =
            HolderRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int = arrayData.size

    override fun onBindViewHolder(holder: MyRecyclerViewHolder, position: Int) {
        holder.bind(arrayData[position])
    }

}
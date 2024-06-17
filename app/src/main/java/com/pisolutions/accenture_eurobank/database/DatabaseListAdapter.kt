package com.pisolutions.accenture_eurobank.database

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pisolutions.accenture_eurobank.databinding.HolderDatabaseRowBinding

class DatabaseListAdapter(private val dataList: List<UserEntity>) :
    RecyclerView.Adapter<DatabaseListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatabaseListViewHolder {
        val binding =
            HolderDatabaseRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return DatabaseListViewHolder(binding)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: DatabaseListViewHolder, position: Int) {
        holder.bind(dataList.get(position))
    }

}
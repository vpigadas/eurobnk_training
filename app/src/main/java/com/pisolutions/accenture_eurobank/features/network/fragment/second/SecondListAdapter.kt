package com.pisolutions.accenture_eurobank.features.network.fragment.second

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pisolutions.accenture_eurobank.databinding.HolderSecondListBinding

class SecondListAdapter(
    private val dataList: List<String>,
    private val listener: (String) -> Unit
) : RecyclerView.Adapter<SecondListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondListViewHolder {
        val view =
            HolderSecondListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return SecondListViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: SecondListViewHolder, position: Int) {
        holder.binding.holderSecondTitle.text = dataList[position]
        holder.binding.holderSecondTitle.setOnClickListener {
            listener(dataList[position])
        }
    }

}

class SecondListViewHolder(val binding: HolderSecondListBinding) :
    RecyclerView.ViewHolder(binding.root) {

}
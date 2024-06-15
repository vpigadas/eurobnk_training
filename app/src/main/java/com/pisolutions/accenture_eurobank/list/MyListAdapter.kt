package com.pisolutions.accenture_eurobank.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pisolutions.accenture_eurobank.databinding.HolderRecyclerView2Binding
import com.pisolutions.accenture_eurobank.databinding.HolderRecyclerViewBinding

class MyListAdapter(data: List<String>) : RecyclerView.Adapter<GenericViewHolder>() {

    private val dataList: List<String> = data
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {
        when (viewType == 0) {
            true -> {
                val binding =
                    HolderRecyclerViewBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                return MyListViewHolder(binding)
            }

            false -> {
                val binding2 =
                    HolderRecyclerView2Binding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                return MyListViewHolder2(binding2)
            }
        }
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        if(holder is MyListViewHolder){
            holder.binding.holderTitle.text =
                "position -> ".plus(position).plus(" value -> ").plus(dataList.get(position))
        }else if (holder is MyListViewHolder2){
            holder.binding.holderTitle.text =
                "position <- ".plus(position).plus(" value <- ").plus(dataList.get(position))
        }

    }

    override fun getItemViewType(position: Int): Int {
        if(position % 4 == 0){
            return 1
        }else{
            return super.getItemViewType(position)
        }
    }

}
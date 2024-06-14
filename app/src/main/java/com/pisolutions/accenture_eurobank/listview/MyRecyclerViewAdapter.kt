package com.pisolutions.accenture_eurobank.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pisolutions.accenture_eurobank.databinding.HolderRecyclerViewBinding

class MyRecyclerViewAdapter(
    private val context: Context,
    private val arrayData: List<String>
) : RecyclerView.Adapter<MyRecyclerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecyclerViewHolder {
        val view2 = HolderRecyclerViewBinding.inflate(LayoutInflater.from(context), parent, false)
//        val view: View =
//            LayoutInflater.from(context).inflate(R.layout.holder_recycler_view, parent, false)

        return MyRecyclerViewHolder(view2)
    }

    override fun getItemCount(): Int = arrayData.size

    override fun onBindViewHolder(holder: MyRecyclerViewHolder, position: Int) {
        holder.binding.holderTitle.text = arrayData.get(position)
    }

}
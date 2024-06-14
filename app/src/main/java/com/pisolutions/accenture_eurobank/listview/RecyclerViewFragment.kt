package com.pisolutions.accenture_eurobank.listview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pisolutions.accenture_eurobank.databinding.FragmentRecyclerViewBinding

class RecyclerViewFragment : Fragment() {

    private lateinit var binding: FragmentRecyclerViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecyclerViewBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mContext = context
        if (mContext != null) {
            binding.recyclerView.adapter = MyRecyclerViewAdapter(getArrayData())
        }
    }

    private fun getArrayData(): List<String> {
        val arrayData = mutableListOf<String>()
        (10..1000).forEach {
            arrayData.add(it.toString())
        }

        return arrayData
    }
}
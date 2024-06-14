package com.pisolutions.accenture_eurobank.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pisolutions.accenture_eurobank.databinding.FragmentList2Binding

class List2Fragment : Fragment() {

    private lateinit var binding: FragmentList2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentList2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = MyListAdapter(getListData())

    }

    private fun getListData(): List<String> = listOf("5", "6", "7", "8", "9", "10", "11", "12")
}
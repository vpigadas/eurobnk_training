package com.pisolutions.accenture_eurobank.storage

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pisolutions.accenture_eurobank.databinding.FragmentStorageBinding

class StorageFragment : Fragment() {
    private lateinit var binding: FragmentStorageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStorageBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedpreferences = activity?.getSharedPreferences("abc", MODE_PRIVATE)
        var number = sharedpreferences?.getInt("number", 0) ?: 0

        binding.storageFragTitle.text = number.toString()

        binding.storageFragButton.setOnClickListener {
            val editor = sharedpreferences?.edit()
            editor?.putInt("number", ++number)
            editor?.commit()
            editor?.apply()

            binding.storageFragTitle.text = number.toString()
        }

    }
}
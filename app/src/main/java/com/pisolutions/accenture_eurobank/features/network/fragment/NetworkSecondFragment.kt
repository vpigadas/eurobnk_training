package com.pisolutions.accenture_eurobank.features.network.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pisolutions.accenture_eurobank.databinding.FragmentNetworkSecondBinding

class NetworkSecondFragment : Fragment() {

    private lateinit var binding: FragmentNetworkSecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNetworkSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = arguments?.getString("selectedValue") ?: ""

        binding.networkSecondTitle.text = title
    }

    companion object {
        @JvmStatic
        fun newInstance(value: String): NetworkSecondFragment {
            val fragment = NetworkSecondFragment()
            val parameters = Bundle()
            parameters.putString("selectedValue", value)
            fragment.arguments = parameters
            return fragment
        }
    }
}
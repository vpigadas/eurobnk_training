package com.pisolutions.accenture_eurobank.features.network.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pisolutions.accenture_eurobank.databinding.FragmentNetworkMainBinding
import com.pisolutions.accenture_eurobank.features.network.NetworkViewModel
import com.pisolutions.accenture_eurobank.features.network.fragment.second.SecondListAdapter

class NetworkMainFragment : Fragment() {

    private lateinit var binding: FragmentNetworkMainBinding
    private lateinit var viewModel: NetworkViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val act = activity
        viewModel = if (act != null) {
            ViewModelProvider(act).get(NetworkViewModel::class.java)
        } else {
            ViewModelProvider(this).get(NetworkViewModel::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNetworkMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.makeARestApiCall()

        viewModel.streamListData.observe(viewLifecycleOwner, Observer { dataList ->
            binding.networkMainRecycler.adapter =
                SecondListAdapter(dataList = dataList, listener = { value ->
                    Log.d("TAG", "user select the item ".plus(value))
                    viewModel.itemSelected(value)
                })
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = NetworkMainFragment()
    }
}
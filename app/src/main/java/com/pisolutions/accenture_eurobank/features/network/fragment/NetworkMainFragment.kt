package com.pisolutions.accenture_eurobank.features.network.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.pisolutions.accenture_eurobank.databinding.FragmentNetworkMainBinding
import com.pisolutions.accenture_eurobank.features.network.NetworkViewModel
import com.pisolutions.accenture_eurobank.features.network.fragment.second.SecondListAdapter
import com.pisolutions.accenture_eurobank.network.JsonResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.runBlocking

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


        val client = HttpClient(CIO)

        runBlocking {
            val response =
                client.get("http://petstore.swagger.io/v2/pet/findByStatus?status=available")
            Log.d("RESPONSE", response.bodyAsText())

            val jsonResponse =
                Gson().fromJson(response.bodyAsText(), Array<JsonResponse>::class.java)

            val dataList = jsonResponse.mapNotNull { it.ide.toString() }

            binding.networkMainRecycler.adapter =
                SecondListAdapter(dataList = dataList, listener = { value ->
                    Log.d("TAG", "user select the item ".plus(value))
                    viewModel.selectedItem = value
                    viewModel.streamSelectedItem.postValue(value)
                })
        }
    }

    override fun onResume() {
        super.onResume()

        Log.d("TAG Fragment", "selected item value -> ".plus(viewModel.selectedItem))
    }

    companion object {
        @JvmStatic
        fun newInstance() = NetworkMainFragment()
    }
}
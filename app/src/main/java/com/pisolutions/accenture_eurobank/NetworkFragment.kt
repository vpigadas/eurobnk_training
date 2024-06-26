package com.pisolutions.accenture_eurobank

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.pisolutions.accenture_eurobank.databinding.FragmentNetworkBinding
import com.pisolutions.accenture_eurobank.network.JsonResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class NetworkFragment : Fragment() {

    private lateinit var binding: FragmentNetworkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNetworkBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val client = HttpClient(CIO)

        runBlocking {
            val response =
                client.get("http://petstore.swagger.io/v2/pet/findByStatus?status=available")
            Log.d("RESPONSE", response.bodyAsText())

            binding.networkText.text = response.bodyAsText()
            val jsonResponse =
                Gson().fromJson(response.bodyAsText(), Array<JsonResponse>::class.java)
            jsonResponse
        }

    }
}
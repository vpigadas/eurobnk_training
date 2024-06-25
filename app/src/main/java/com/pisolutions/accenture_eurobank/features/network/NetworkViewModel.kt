package com.pisolutions.accenture_eurobank.features.network

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pisolutions.accenture_eurobank.features.network.fragment.NetworkMainFragment
import com.pisolutions.accenture_eurobank.features.network.fragment.NetworkSecondFragment
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NetworkViewModel : ViewModel() {

    private val apiUrl = "http://petstore.swagger.io/v2/pet/findByStatus?status=available"

    private val repository: NetworkRepository = NetworkRepository()

    private val _streamFragments: MutableLiveData<Fragment> =
        MutableLiveData(NetworkMainFragment.newInstance())
    val streamFragments: LiveData<Fragment> = _streamFragments

    private val _streamListData: MutableLiveData<List<String>> =
        MutableLiveData(emptyList<String>())
    val streamListData = _streamListData

    fun itemSelected(data: String) {
        _streamFragments.postValue(NetworkSecondFragment.newInstance(data))
    }

    fun makeARestApiCall() {
        val client = HttpClient(CIO)

        viewModelScope.launch {
            val response = client.get(apiUrl)
            Log.d("RESPONSE", response.bodyAsText())

            repository.transform(response.bodyAsText())

            delay(5000)
            _streamListData.postValue(repository.dataList.subList(0, repository.counter))
            repository.increaseCounter()
        }
    }
}
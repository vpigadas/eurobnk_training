package com.pisolutions.accenture_eurobank.features.network

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NetworkViewModel : ViewModel() {

    var selectedItem: String = ""

    val streamSelectedItem: MutableLiveData<String> = MutableLiveData()
}
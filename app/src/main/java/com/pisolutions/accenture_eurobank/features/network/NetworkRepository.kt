package com.pisolutions.accenture_eurobank.features.network

import com.google.gson.Gson
import com.pisolutions.accenture_eurobank.network.JsonResponse

class NetworkRepository {
    var counter = 2

    var dataList: List<String> = emptyList()

    fun increaseCounter() {
        counter += 2
    }

    fun transform(response: String) {
        val jsonResponse =
            Gson().fromJson(response, Array<JsonResponse>::class.java)

        dataList = jsonResponse.mapNotNull { it.ide.toString() }
    }
}
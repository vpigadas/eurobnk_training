package com.pisolutions.accenture_eurobank.network

import com.google.gson.annotations.SerializedName

data class JsonResponse(
    @SerializedName(value = "id") val ide:Long,
    val name:String
)
package com.pisolutions.accenture_eurobank.features.score

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {

    val scoreCount: MutableLiveData<Int> = MutableLiveData(0)

    fun increaseNumber() {
        val savedValue = scoreCount.value ?: 0
        scoreCount.postValue(savedValue.plus(1))
    }

    fun decreaseNumber() {
        val savedValue = scoreCount.value ?: 0
        scoreCount.postValue(savedValue.minus(1))
    }
}
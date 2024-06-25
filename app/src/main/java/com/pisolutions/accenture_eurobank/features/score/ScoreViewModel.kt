package com.pisolutions.accenture_eurobank.features.score

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.pisolutions.accenture_eurobank.features.score.database.ScoreDatabase
import com.pisolutions.accenture_eurobank.features.score.database.ScoreEntity
import kotlinx.coroutines.launch

class ScoreViewModel(application: Application) : AndroidViewModel(application) {

    val scoreCount: MutableLiveData<Int> = MutableLiveData(0)

    private var sharedPreference: SharedPreferences =
        getApplication<Application>().getSharedPreferences("score", MODE_PRIVATE)

    private var database: ScoreDatabase =
        Room.databaseBuilder(application, ScoreDatabase::class.java, "Score")
            .fallbackToDestructiveMigration().build()

    fun onStart() {
//        val savedValue = sharedPreference.getInt("value", 0)
//        scoreCount.postValue(savedValue)


        viewModelScope.launch {
            val savedValue = database.getScoreDao().getScore()?.score ?: 0
            scoreCount.postValue(savedValue)
        }
    }

    fun increaseNumber() {
        val savedValue = scoreCount.value ?: 0

        val newValue = savedValue.plus(1)
        scoreCount.postValue(newValue)

        viewModelScope.launch {
            val savedDatabaseInstance =
                database.getScoreDao().getScore() ?: ScoreEntity("first", newValue)
            val newDbValue = savedDatabaseInstance.copy(score = newValue)
            saveValue(newDbValue)
        }
    }

    fun decreaseNumber() {
        val savedValue = scoreCount.value ?: 0

        val newValue = savedValue.minus(1)
        scoreCount.postValue(newValue)

        viewModelScope.launch {
            val savedDatabaseInstance =
                database.getScoreDao().getScore() ?: ScoreEntity("first", newValue)
            val newDbValue = savedDatabaseInstance.copy(score = newValue)
            saveValue(newDbValue)
        }
    }

    private fun saveValue(value: Int) {
        sharedPreference.edit().putInt("value", value).apply()
    }

    private suspend fun saveValue(value: ScoreEntity?) {
        value ?: return

        database.getScoreDao().save(value)
    }

}
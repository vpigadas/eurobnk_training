package com.pisolutions.accenture_eurobank.features.score.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ScoreEntity::class], version = 2)
abstract class ScoreDatabase : RoomDatabase() {
    abstract fun getScoreDao(): ScoreDao
}
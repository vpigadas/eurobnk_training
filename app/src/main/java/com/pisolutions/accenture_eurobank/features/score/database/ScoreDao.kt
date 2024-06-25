package com.pisolutions.accenture_eurobank.features.score.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ScoreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(data: ScoreEntity)

    @Delete
    suspend fun delete(data: ScoreEntity)

    @Query("SELECT * FROM Score")
    suspend fun getScores(): List<ScoreEntity>

    @Query("SELECT * FROM Score LIMIT 1")
    suspend fun getScore(): ScoreEntity?

}
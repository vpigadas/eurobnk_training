package com.pisolutions.accenture_eurobank.features.score.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Score")
data class ScoreEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "score") val score: Int
)
package com.pisolutions.accenture_eurobank.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1)
abstract class MyDatabaseInstance : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}
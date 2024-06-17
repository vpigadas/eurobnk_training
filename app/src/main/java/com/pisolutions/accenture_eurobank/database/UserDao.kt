package com.pisolutions.accenture_eurobank.database

import android.database.SQLException
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlin.jvm.Throws

@Dao
interface UserDao {

    @Insert
    @Throws(SQLException::class)
    fun create(data: UserEntity)

    @Update
    @Throws(SQLException::class)
    fun update(data: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(data:UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(vararg data:UserEntity)

    @Delete
    fun delete(data: UserEntity)

    @Query("SELECT * FROM UserEntity")
    fun readAll() : List<UserEntity>

    @Query("SELECT * FROM UserEntity LIMIT 1")
    fun readFirst() : UserEntity?

    @Query("SELECT * FROM UserEntity WHERE first_name LIKE :firstName ")
    fun read(firstName:String) : List<UserEntity>

}
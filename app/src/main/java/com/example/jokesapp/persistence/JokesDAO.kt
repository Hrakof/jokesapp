package com.example.jokesapp.persistence

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface JokesDao {
    @Query("SELECT * FROM jokes")
    fun getAllJokes(): Flow<List<RoomJoke>>

    @Query("SELECT * FROM categories")
    fun getAllCategories(): Flow<List<RoomCategory>>
}
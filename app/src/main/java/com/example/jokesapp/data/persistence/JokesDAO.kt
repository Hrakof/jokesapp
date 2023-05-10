package com.example.jokesapp.data.persistence

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface JokesDao {
    @Query("SELECT * FROM categories")
    fun getAllCategories(): List<RoomCategory>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: RoomCategory)

    @Query("SELECT * FROM jokes where category = :categoryName ORDER BY RANDOM() LIMIT 1")
    fun getRandomJokeFromCategory(categoryName: String): 
}
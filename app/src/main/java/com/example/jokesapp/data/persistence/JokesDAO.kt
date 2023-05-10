package com.example.jokesapp.data.persistence

import androidx.room.*

@Dao
interface JokesDao {
    @Query("SELECT * FROM categories")
    fun getAllCategories(): List<RoomCategory>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: RoomCategory)

    @Query("SELECT * FROM jokes where category_name = :categoryName ORDER BY RANDOM() LIMIT 1")
    fun getRandomJokeFromCategory(categoryName: String): RoomJoke?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertJoke(joke: RoomJoke)
}
package com.example.jokesapp.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [RoomCategory::class, RoomJoke::class], version = 1, exportSchema = false)
abstract class JokesDatabase : RoomDatabase() {
    abstract fun jokesDao(): JokesDao
}
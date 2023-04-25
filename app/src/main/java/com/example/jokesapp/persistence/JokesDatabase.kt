package com.example.jokesapp.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [RoomCategory::class, RoomJoke::class], version = 1, exportSchema = false)
abstract class JokesDatabase : RoomDatabase() {
    abstract fun jokesDao(): JokesDao

    companion object {
        @Volatile
        private var Instance: JokesDatabase? = null

        fun getDatabase(context: Context): JokesDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, JokesDatabase::class.java, "jokes_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
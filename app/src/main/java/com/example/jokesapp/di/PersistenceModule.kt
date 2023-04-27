package com.example.jokesapp.di

import android.content.Context
import androidx.room.Room
import com.example.jokesapp.data.persistence.JokesDao
import com.example.jokesapp.data.persistence.JokesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): JokesDatabase {
        return Room.databaseBuilder(context, JokesDatabase::class.java, "jokes_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideMyDao(database: JokesDatabase): JokesDao {
        return database.jokesDao()
    }
}
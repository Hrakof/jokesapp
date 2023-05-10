package com.example.jokesapp.di

import android.content.Context
import com.example.jokesapp.data.network.JokesService
import com.example.jokesapp.data.persistence.JokesDao
import com.example.jokesapp.data.repository.JokesRepository
import com.example.jokesapp.data.repository.JokesRepositoryImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideJokesRepository(@ApplicationContext appContext: Context, service: JokesService, dao: JokesDao): JokesRepository{
        return JokesRepositoryImplementation(appContext, service, dao)
    }
}
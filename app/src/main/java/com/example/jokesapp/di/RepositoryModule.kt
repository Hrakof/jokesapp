package com.example.jokesapp.di

import com.example.jokesapp.data.network.JokesService
import com.example.jokesapp.data.persistence.JokesDao
import com.example.jokesapp.data.repository.JokesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideJokesRepository(service: JokesService, dao: JokesDao): JokesRepository{
        return JokesRepository(service, dao)
    }
}
package com.example.jokesapp.di

import com.example.jokesapp.data.network.BASE_URL
import com.example.jokesapp.data.network.JokesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideJokesService(): JokesService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(JokesService::class.java)
    }
}
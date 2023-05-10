package com.example.jokesapp.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


const val BASE_URL = "https://api.chucknorris.io/jokes/"

interface JokesService {
    @GET("categories")
    suspend fun getCategories(): Response<Array<String>>
    @GET("random")
    suspend fun getRandomJoke(@Query("category") category: String? = null): Response<RandomJokeResponse>
}

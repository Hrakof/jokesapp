package com.example.jokesapp.network

import retrofit2.Retrofit


private val retrofit = Retrofit.Builder()
    .baseUrl("https://api.chucknorris.io/jokes")
    .build()

object JokesApi {
    val retrofitService: JokesService by lazy {
        retrofit.create(JokesService::class.java)
    }
}

interface JokesService {

}

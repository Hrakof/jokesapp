package com.example.jokesapp.data.network

data class RandomJokeResponse (
    val value: String,
    val categories: Array<String>? = null,
    val created_at: String? = null,
    val icon_url: String? = null,
    val id: String? = null,
    val updated_at: String? = null,
    val url: String? = null
)



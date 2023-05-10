package com.example.jokesapp.data.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.jokesapp.data.network.JokesService
import com.example.jokesapp.data.persistence.JokesDao
import com.example.jokesapp.data.persistence.RoomCategory
import com.example.jokesapp.data.persistence.RoomJoke
import java.util.*


class JokesRepository(private val context: Context, private val jokesService: JokesService, private val jokesDao: JokesDao) {
    suspend fun getAllCategories(): List<Category> {
        if (isInternetAvailable()) {
            val result = jokesService.getCategories().body()?.map { categoryName ->
                Category(0, categoryName)
            }
            if (result != null)
                return result
        }
        return jokesDao.getAllCategories().map { roomCategory ->
            Category(roomCategory.id, roomCategory.name)
        }
    }
    suspend fun getRandomJokeFromCategory(categoryName: String): Joke? {
        if (isInternetAvailable()) {
            val result = jokesService.getRandomJoke(categoryName).body()
            if (result != null)
                return Joke(result.id, result.value)
        }
        val roomJoke = jokesDao.getRandomJokeFromCategory(categoryName) ?: return null
        return Joke(roomJoke.id, roomJoke.text)
    }

    fun insertCategory(category: Category){
        jokesDao.insertCategory(RoomCategory(category.id, category.name))
    }

    fun insertJoke(joke: Joke, categoryName: String){
        val id = joke.id ?: UUID.randomUUID().toString()
        jokesDao.insertJoke(RoomJoke(id, joke.text, categoryName))
    }

    private fun isInternetAvailable(): Boolean{
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        return networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
    }
}
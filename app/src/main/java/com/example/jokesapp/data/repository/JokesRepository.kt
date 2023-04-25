package com.example.jokesapp.data.repository

import com.example.jokesapp.data.network.JokesService
import com.example.jokesapp.data.persistence.JokesDao

class JokesRepository(val jokesService: JokesService, val jokesDao: JokesDao) {
    fun getAllCategories(){}
    fun getRandomJoke(){}
}
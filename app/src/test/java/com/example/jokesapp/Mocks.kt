package com.example.jokesapp

import com.example.jokesapp.data.network.JokesService
import com.example.jokesapp.data.network.RandomJokeResponse
import com.example.jokesapp.data.persistence.JokesDao
import com.example.jokesapp.data.persistence.RoomCategory
import com.example.jokesapp.data.persistence.RoomJoke
import com.example.jokesapp.data.repository.Category
import com.example.jokesapp.data.repository.Joke
import com.example.jokesapp.data.repository.JokesRepository
import retrofit2.Response

class MockJokesService: JokesService{
    override suspend fun getCategories(): Response<Array<String>> {
        TODO("Not yet implemented")
    }

    override suspend fun getRandomJoke(category: String?): Response<RandomJokeResponse> {
        TODO("Not yet implemented")
    }
}

class MockJokesDAO: JokesDao{
    override fun getAllCategories(): List<RoomCategory> {
        TODO("Not yet implemented")
    }

    override fun insertCategory(category: RoomCategory) {
        TODO("Not yet implemented")
    }

    override fun getRandomJokeFromCategory(categoryName: String): RoomJoke? {
        TODO("Not yet implemented")
    }

    override fun insertJoke(joke: RoomJoke) {
        TODO("Not yet implemented")
    }
}

class MockJokesRepository: JokesRepository{
    override suspend fun getAllCategories(): List<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun getRandomJokeFromCategory(categoryName: String): Joke? {
        TODO("Not yet implemented")
    }

    override fun insertCategory(category: Category) {
        TODO("Not yet implemented")
    }

    override fun insertJoke(joke: Joke, categoryName: String) {
        TODO("Not yet implemented")
    }

}

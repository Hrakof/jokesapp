package com.example.jokesapp.ui.screen.joke

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import com.example.jokesapp.data.repository.Category
import com.example.jokesapp.data.repository.JokesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class JokeViewModel @Inject constructor(
    private val repository: JokesRepository
) : ViewModel() {

    fun getRandomJoke(): Flow<List<Category>> = flow {
        val categoryList = listOf(
            Category("test category 1"),
            Category("test category 2"),
            Category("test category 3"),
        )
        emit(categoryList)
    }

}
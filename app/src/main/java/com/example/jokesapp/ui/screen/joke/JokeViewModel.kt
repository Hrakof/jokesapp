package com.example.jokesapp.ui.screen.joke

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.jokesapp.data.repository.Joke
import com.example.jokesapp.data.repository.JokesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class JokeViewModel @Inject constructor(
    private val repository: JokesRepository,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    var categoryName: String? = savedStateHandle.get<String>("categoryname").orEmpty()
    fun getRandomJoke(): Joke = Joke("Test joke")

}
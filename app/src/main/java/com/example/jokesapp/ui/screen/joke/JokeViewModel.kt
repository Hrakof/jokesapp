package com.example.jokesapp.ui.screen.joke

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jokesapp.data.repository.Joke
import com.example.jokesapp.data.repository.JokesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokeViewModel @Inject constructor(
    private val repository: JokesRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    var categoryName: String?

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean>
        get() = _isRefreshing.asStateFlow()

    private val _joke = MutableStateFlow<Joke?>(null)
    val joke: StateFlow<Joke?>
        get() = _joke.asStateFlow()

    init {
        categoryName = savedStateHandle.get<String>("categoryname").orEmpty()
        refresh()
    }
    fun refresh(){
        viewModelScope.launch(Dispatchers.IO) {
            _isRefreshing.emit(true)
            val fetchedJoke = repository.getRandomJokeFromCategory(categoryName)
            _joke.emit(fetchedJoke)
            _isRefreshing.emit(false)
        }
    }
}
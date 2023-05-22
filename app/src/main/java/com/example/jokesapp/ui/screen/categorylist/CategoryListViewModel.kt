package com.example.jokesapp.ui.screen.categorylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jokesapp.data.repository.Category
import com.example.jokesapp.data.repository.JokesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryListViewModel @Inject constructor(
    private val repository: JokesRepository
) : ViewModel() {

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean>
        get() = _isRefreshing.asStateFlow()

    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>>
        get() = _categories.asStateFlow()

    init {
        refresh()
    }
    fun refresh(){
        viewModelScope.launch(Dispatchers.IO) {
            val fetchedCategories = repository.getAllCategories()
            _categories.emit(fetchedCategories)
            _isRefreshing.emit(false)
        }
    }

    fun getAllCategories(): Flow<List<Category>> = flow {
        val categoryList = listOf(
            Category(0, "test category 1"),
            Category(0, "test category 2"),
            Category(0, "test category 3"),
        )
        emit(categoryList)
    }

}
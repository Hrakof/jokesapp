package com.example.jokesapp.ui.screen.categorylist

import androidx.lifecycle.ViewModel
import com.example.jokesapp.data.repository.Category
import com.example.jokesapp.data.repository.JokesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class CategoryListViewModel @Inject constructor(
    private val repository: JokesRepository
) : ViewModel() {

    fun getAllCategories(): Flow<List<Category>> = flow {
        val categoryList = listOf(
            Category(0, "test category 1"),
            Category(0, "test category 2"),
            Category(0, "test category 3"),
        )
        emit(categoryList)
    }

}
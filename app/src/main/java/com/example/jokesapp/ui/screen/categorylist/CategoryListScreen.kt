package com.example.jokesapp.ui.screen.categorylist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController


@Composable
fun CategoryListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: CategoryListViewModel = hiltViewModel<CategoryListViewModel>()
) {
    val categories by viewModel.getAllCategories().collectAsStateWithLifecycle(emptyList())
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Category list")
                }
            )
        },
        content = { paddingValues ->
            LazyColumn(contentPadding = paddingValues) {
                items(categories.size) { index ->
                    Text(
                        categories[index].name,
                        modifier=Modifier.clickable {
                            navController.navigate("joke/${categories[index].name}")
                        }
                    )
                }
            }
        }
    )
}

package com.example.jokesapp.ui.screen.joke

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun JokeScreen(
    modifier: Modifier = Modifier,
    viewModel: JokeViewModel = hiltViewModel<JokeViewModel>(),
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Random joke")
                }
            )
        },
        content = { paddingValues ->
            Box(modifier = modifier.padding(paddingValues)) {
                Text("A joke in the \"${viewModel.categoryName ?: ""}\" category: ${viewModel.getRandomJoke().text}")
            }
        }
    )
}

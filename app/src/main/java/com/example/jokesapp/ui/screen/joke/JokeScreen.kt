package com.example.jokesapp.ui.screen.joke

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.launch


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
                Text("Joke")
            }
        }
    )
}

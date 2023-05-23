package com.example.jokesapp.ui.screen.joke

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.jokesapp.ui.composables.ChuckLogo


@Composable
fun JokeScreen(
    viewModel: JokeViewModel = hiltViewModel(),
) {
    val themeColors = MaterialTheme.colors
    val joke by viewModel.joke.collectAsStateWithLifecycle()
    val isRefreshing by viewModel.isRefreshing.collectAsStateWithLifecycle()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text("${viewModel.categoryName ?: ""} joke")},
                backgroundColor = themeColors.primary,
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                ) {
                    ChuckLogo()

                    if (isRefreshing) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(128.dp)
                                .padding(16.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                    } else {
                        Text(
                            text = joke?.text ?: "Could not find a joke in this category",
                            modifier = Modifier.padding(16.dp),
                            fontSize = 32.sp,
                        )
                    }
                }

                Button(
                    onClick = { viewModel.refresh() },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 32.dp)
                        .size(width = 128.dp, height = 64.dp)
                ) {
                    Text("Next", fontSize = 32.sp)
                }
            }
        }
    )
}

package com.example.jokesapp.ui.screen.categorylist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.jokesapp.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text



@Composable
fun CategoryListScreen(
    navController: NavController,
) {
    val themeColors = MaterialTheme.colors
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Category list") },
                backgroundColor = themeColors.primary
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
            ) {
                Logo()
                Spacer(modifier = Modifier.height(16.dp))
                CategoryList(navController)
            }
        }
    )
}

@Composable
fun Logo() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.mipmap.chucknorris_io_logo_foreground),
            contentDescription = null,
            modifier = Modifier
                .size(250.dp),
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategoryList(
    navController: NavController,
    viewModel: CategoryListViewModel = hiltViewModel()
) {
    val themeColors = MaterialTheme.colors
    val categories by viewModel.categories.collectAsStateWithLifecycle()
    val isRefreshing by viewModel.isRefreshing.collectAsStateWithLifecycle()
    val pullRefreshState = rememberPullRefreshState(isRefreshing, { viewModel.refresh() })

    Box(
        Modifier
            .pullRefresh(pullRefreshState),
    ){
        LazyColumn(
            modifier = Modifier.fillMaxSize().background(color = themeColors.primarySurface),
            contentPadding = PaddingValues(horizontal = 32.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(categories.size) { index ->
                Card(backgroundColor = themeColors.primary) {
                    Text(
                        text = categories[index].name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable {
                                navController.navigate("joke/${categories[index].name}")
                            }
                    )
                }
            }
        }
        PullRefreshIndicator(isRefreshing, pullRefreshState, Modifier.align(Alignment.TopCenter))
    }
}


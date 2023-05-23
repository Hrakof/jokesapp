package com.example.jokesapp.ui.screen.categorylist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.jokesapp.ui.composables.ChuckLogo
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase


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
                ChuckLogo()
                CategoryList(navController)
            }
        }
    )
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

    val firebaseAnalytics = Firebase.analytics

    Box(
        Modifier
            .pullRefresh(pullRefreshState),
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = themeColors.primarySurface),
            contentPadding = PaddingValues(horizontal = 32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(categories.size) { index ->
                Card(
                    backgroundColor = themeColors.primary,
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .clickable {
                            val categoryName = categories[index].name
                            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM) {
                                param("joke_category_name", categoryName)
                            }
                            navController.navigate("joke/$categoryName")
                        }
                ) {
                    Text(
                        text = categories[index].name,
                        textAlign = TextAlign.Center,
                        fontSize = 32.sp,
                        modifier = Modifier.padding(16.dp),
                    )
                }
            }
        }
        PullRefreshIndicator(isRefreshing, pullRefreshState, Modifier.align(Alignment.TopCenter))
    }
}


package com.example.jokesapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jokesapp.ui.screen.categorylist.CategoryListScreen
import com.example.jokesapp.ui.screen.joke.JokeScreen


@Composable
fun JokesAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "categorylist"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("categorylist") { CategoryListScreen(navController = navController) }

        composable("joke/{categoryname}",
            arguments = listOf(
                navArgument("categoryname"){type = NavType.StringType}
            )
        ) { backStackEntry ->
            val categoryName = backStackEntry.arguments?.getString("categoryname")
            categoryName?.let {
                JokeScreen()
            }
        }
    }
}
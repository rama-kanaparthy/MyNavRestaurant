package com.rama.mynavrestaurant.navigation


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rama.mynavrestaurant.screens.ExploreScreen
import com.rama.mynavrestaurant.screens.HomeScreen
import com.rama.mynavrestaurant.screens.RestaurantsScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Explore : Screen("explore")
    object Restaurant : Screen("restaurant")
}

@Composable
fun NavigationGraph(contentPadding: PaddingValues, onTitleChanged: (String) -> Unit) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(
                contentPadding,
                onTitleChanged = onTitleChanged,
                onNavigateToExplore = {
                    navController.navigate(Screen.Explore.route)
                }
            )
        }
        composable(Screen.Explore.route) {
            ExploreScreen(
                contentPadding,
                onTitleChanged = onTitleChanged,
                onNavigateToRestaurant = {
                        name -> navController.navigate(
                    "${Screen.Restaurant.route}/$name")
                }
            )
        }
        composable(
            "${Screen.Restaurant.route}/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) {
                backStackEntry->
            RestaurantsScreen(
                contentPadding,
                restaurantName = backStackEntry.arguments?.getString("name"),
                onTitleChanged = onTitleChanged,
                onNavigateToExplore = { navController.navigate(Screen.Explore.route) }
            )
        }
    }
}
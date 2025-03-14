package com.rama.mynavrestaurant.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rama.mynavrestaurant.screens.BottomNavigationBar
import com.rama.mynavrestaurant.screens.ExploreScreen
import com.rama.mynavrestaurant.screens.HomeScreen
import com.rama.mynavrestaurant.screens.RestaurantsScreen
import com.rama.mynavrestaurant.screens.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantApp() {
    val navController = rememberNavController()
    var appBarTitle = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        appBarTitle.value,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        bottomBar = {
            BottomNavigationBar(onNavigate = {
                    screen: Screen -> navController.navigate(screen.route)
            }
            )
        }
    ) {
            contentPadding -> NavigationGraph(navController, contentPadding) {
            title -> appBarTitle.value = title
    }
    }
}


@Composable
fun NavigationGraph(
    navController: NavHostController,
    contentPadding: PaddingValues,
    onTitleChanged: (String) -> Unit
) {

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = Modifier.padding(contentPadding)
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onTitleChanged = onTitleChanged,
                onNavigateToExplore = { navController.navigate(Screen.Explore.route) }
            )
        }
        composable(Screen.Explore.route) {
            ExploreScreen(
                onTitleChanged = onTitleChanged,
                onNavigateToRestaurants = { navController.navigate(Screen.Restaurants.route) }
            )
        }
        composable(Screen.Restaurants.route) {
            RestaurantsScreen(
                onTitleChanged = onTitleChanged,
                onNavigateToExplore = { navController.navigate(Screen.Explore.route) }
            )
        }
    }
}
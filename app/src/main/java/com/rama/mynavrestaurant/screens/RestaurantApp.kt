package com.rama.mynavrestaurant.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.rama.mynavrestaurant.data.Restaurant
import com.rama.mynavrestaurant.R
import com.rama.mynavrestaurant.ui.RestaurantList


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantApp() {
    val snackbarHostState = remember { SnackbarHostState() }

    val restaurants = remember { mutableStateListOf(
        Restaurant(11, "Belgian Waffles",
            "The best in town!", R.drawable.restaurant_01),
        Restaurant(12,"Stomachful",
            "Never leave hungry", R.drawable.restaurant_02),
        Restaurant(13,"Big Belly Noodles",
            "Delicious noodles", R.drawable.restaurant_03),
        Restaurant(14,"Cakery",
            "Cakes for every occasion", R.drawable.restaurant_04),
        Restaurant(15,"Pan Asia",
            "The best Asian food", R.drawable.restaurant_05),
        Restaurant(16,"House of Pancakes",
            "Best for breakfast", R.drawable.restaurant_06),
        Restaurant(17,"Sizzling Steakhouse",
            "Come for the sizzle", R.drawable.restaurant_07),
        Restaurant(18,"Something fishy",
            "Everything from the sea", R.drawable.restaurant_08),
        Restaurant(19,"Pasta Ya Gotcha",
            "Pastas and more", R.drawable.restaurant_09),
        Restaurant(20,"Healthy and Yummy",
            "Can't believe it's healthy!", R.drawable.restaurant_10),
    )}

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Eatelicious",
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    val shuffledRestaurants = restaurants.shuffled()
                    restaurants.clear()

                    restaurants.addAll(shuffledRestaurants)
                }
            ) {
                Icon(Icons.Filled.Edit, contentDescription = null)
            }
        }
    ) {
            contentPadding ->
        Box() {
            RestaurantList(restaurants, contentPadding, snackbarHostState)
            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                    snackbarData ->
                Snackbar(
                    snackbarData = snackbarData
                )
            }

        }
    }
}

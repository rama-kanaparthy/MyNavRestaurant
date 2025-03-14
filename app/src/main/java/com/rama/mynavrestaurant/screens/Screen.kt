package com.rama.mynavrestaurant.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Place
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val name: String, val icon: ImageVector) {
    object Home : Screen(
        "home", "Home", Icons.Rounded.Home)
    object Explore : Screen(
        "explore", "Explore", Icons.Rounded.Place)
    object Restaurants : Screen(
        "restaurants", "Restaurants", Icons.Rounded.List)
}
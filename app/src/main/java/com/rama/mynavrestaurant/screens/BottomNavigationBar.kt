package com.rama.mynavrestaurant.screens

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

val screens = listOf(Screen.Home, Screen.Explore, Screen.Restaurants)

@Composable
fun BottomNavigationBar(onNavigate: (screen: Screen) -> Unit) {

    BottomNavigation (
        backgroundColor = MaterialTheme.colorScheme.primaryContainer
    ) {

        screens.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(screen.icon, contentDescription = null)
                },
                label = {
                    Text(screen.name)
                },
                selected = false,
                onClick = { onNavigate(screen) }
            )
        }
    }
}
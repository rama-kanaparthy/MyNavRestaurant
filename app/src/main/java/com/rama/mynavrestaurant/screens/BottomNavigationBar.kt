package com.rama.mynavrestaurant.screens

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

val screens = listOf(Screen.Home, Screen.Explore, Screen.Restaurants)

@Composable
fun BottomNavigationBar(onNavigate: (screen: Screen) -> Unit) {

    NavigationBar  {
        screens.forEach { screen ->
            NavigationBarItem(
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
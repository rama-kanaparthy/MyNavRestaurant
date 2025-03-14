package com.rama.mynavrestaurant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.rama.mynavrestaurant.navigation.RestaurantApp
import com.rama.mynavrestaurant.ui.theme.MyNavRestaurantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyNavRestaurantTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    RestaurantApp()
                }
            }
        }
    }
}

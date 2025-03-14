package com.rama.mynavrestaurant.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.rama.eatelicious.compose.RestaurantCard
import com.rama.mynavrestaurant.data.Restaurant

@Composable
fun RestaurantList(
    restaurants: List<Restaurant>,
    contentPadding: PaddingValues,
    snackbarHostState: SnackbarHostState
){
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(
            items = restaurants,
        ){ restaurant ->
            val rememberValue = remember(restaurant) { mutableStateOf(0) }
            RestaurantCard(restaurant = restaurant, rememberValue,snackbarHostState)

        }
    }
}
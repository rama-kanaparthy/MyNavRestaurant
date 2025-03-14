package com.rama.mynavrestaurant.repositories

import com.rama.mynavrestaurant.data.Restaurant
import com.rama.mynavrestaurant.R


class RestaurantsRepository {

    private val restaurants = listOf(
        Restaurant("Belgian Waffles",
            "The best in town!", R.drawable.restaurant_01),
        Restaurant("Stomachful",
            "Never leave hungry", R.drawable.restaurant_02),
        Restaurant("Big Belly Noodles",
            "Delicious noodles", R.drawable.restaurant_03),
        Restaurant("Cakery",
            "Cakes for every occasion", R.drawable.restaurant_04),
        Restaurant("Pan Asia",
            "The best Asian food", R.drawable.restaurant_05),
        Restaurant("House of Pancakes",
            "Best for breakfast", R.drawable.restaurant_06),
        Restaurant("Sizzling Steakhouse",
            "Come for the sizzle", R.drawable.restaurant_07),
        Restaurant("Something fishy",
            "Everything from the sea", R.drawable.restaurant_08),
        Restaurant("Pasta Ya Gotcha",
            "Pastas and more", R.drawable.restaurant_09),
        Restaurant("Healthy and Yummy",
            "Can't believe it's healthy!", R.drawable.restaurant_10),
    )

    fun getRestaurant(name : String): Restaurant? {
        for (restaurant in restaurants) {
            if (restaurant.name == name) {
                return restaurant
            }
        }

        return null
    }

    fun getRestaurants(): List<Restaurant> {
        return restaurants
    }
}
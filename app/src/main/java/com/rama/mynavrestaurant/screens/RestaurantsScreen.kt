package com.rama.mynavrestaurant.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rama.mynavrestaurant.repositories.RestaurantsRepository


@Composable
fun RestaurantsScreen(
    contentPadding: PaddingValues,
    restaurantName: String?,
    onTitleChanged: (String) -> Unit,
    onNavigateToExplore: () -> Unit,
) {
    onTitleChanged("$restaurantName")
    RestaurantsRepository().getRestaurant(restaurantName!!)
        ?.let { restaurant ->

            Column(
                Modifier
                    .padding(contentPadding)
                    .fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.7f)
                ) {
                    Image(
                        painter = painterResource(restaurant.imageId),
                        contentDescription = "restaurant",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RectangleShape),
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .weight(0.3f),
                    contentAlignment = Alignment.Center
                ) {
                    Column (
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            restaurant.name,
                            style = MaterialTheme.typography.headlineLarge,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(
                                start = 16.dp, end = 16.dp
                            )
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            restaurant.tagLine,
                            style = MaterialTheme.typography.bodySmall,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(
                                start = 16.dp, end = 16.dp
                            )
                        )

                        // This will push the buttons to the bottom
                        Spacer(modifier = Modifier.weight(1f))

                        Button(
                            onClick = onNavigateToExplore
                        ) {
                            Text(text = "Explore again")
                        }
                    }
                }

            }
        }
}

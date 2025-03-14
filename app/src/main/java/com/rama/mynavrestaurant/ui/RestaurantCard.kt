package com.rama.eatelicious.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rama.mynavrestaurant.data.Restaurant
import com.rama.mynavrestaurant.ui.theme.Purple40
import kotlinx.coroutines.launch


@Composable
fun RestaurantCard(
    restaurant: Restaurant,
    rememberedValue: MutableState<Int>,
    snackbarHostState: SnackbarHostState
) {

    val coroutineScope = rememberCoroutineScope()

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(
            Color.White
        )
    ) {
        Row (
            Modifier.padding(8.dp).clickable(onClick = {
                rememberedValue.value++

                coroutineScope.launch {

                    // Show the snackbar for a short duration
                    snackbarHostState.showSnackbar(
                        message = "${restaurant.name} has ${rememberedValue.value} like(s)",
                        duration = SnackbarDuration.Short
                    )
                }
            })
        ) {
            Image(
                painter = painterResource(restaurant.imageId),
                contentDescription = "restaurant",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(width = 2.dp, color = Purple40, shape = CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column (modifier = Modifier.fillMaxWidth()) {
                Text(
                    restaurant.name,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(
                        start = 16.dp, end = 16.dp
                    )
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    restaurant.tagLine,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(
                        start = 16.dp, end = 16.dp
                    )
                )
            }
        }
    }
}


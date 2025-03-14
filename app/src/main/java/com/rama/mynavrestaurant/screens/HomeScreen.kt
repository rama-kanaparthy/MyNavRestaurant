package com.rama.mynavrestaurant.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rama.mynavrestaurant.R


@Composable
fun HomeScreen(
    contentPadding: PaddingValues,
    onTitleChanged: (String) -> Unit,
    onNavigateToExplore: () -> Unit,
) {
    onTitleChanged("Eatelicious")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(contentPadding),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.home_page),
            contentDescription = "Home page image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.01f))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column (
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Welcome to Eatelicious",
                    color = Color.White,
                    fontSize = 24.sp,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = onNavigateToExplore
                ) {
                    Text(text = "Explore")
                }
            }

        }
    }
}

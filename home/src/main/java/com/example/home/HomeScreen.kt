package com.example.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.base_ui.Navigator
import com.example.home.navigation.HomeScreens

@Composable
fun HomeScreen(navigator: Navigator) {
    Box(modifier = Modifier
        .clickable {
            navigator.navigate(HomeScreens.RouteList)
        }
        .fillMaxSize()
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Start",
            style = MaterialTheme.typography.displayLarge
        )
    }
}
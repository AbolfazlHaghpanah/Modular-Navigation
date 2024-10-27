package com.example.livan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.base_ui.Navigator
import com.example.livan.navigation.LivanScreens

@Composable
fun UbScreen(navigator: Navigator) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .fillMaxSize()
    ) {
        Column(
            Modifier
                .align(Alignment.Center)
                .background(
                    MaterialTheme.colorScheme.background,
                    MaterialTheme.shapes.large
                )
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var value by remember {
                mutableIntStateOf(0)
            }

            Text(
                text = "How  Much Water You Need \n Feel Free to Ask.",
                style = MaterialTheme.typography.headlineSmall
            )

            TextField(
                value = value.toString(),
                onValueChange = { value = it.takeIf { it.isNotEmpty() }?.toInt() ?: 0 },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Button(onClick = { navigator.navigate(LivanScreens.LivanResult(value)) }) {
                Text(text = "Done")
            }
        }
    }
}
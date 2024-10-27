package com.example.goldoon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.internal.isLiveLiteralsEnabled
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.base_ui.IsLivanAvalible
import com.example.base_ui.Navigator
import com.example.goldoon.navigation.GoldoonScreens
import com.example.goldoon.navigation.GoldoonScreens.Khak


@Composable
fun BargScreen(navigator: Navigator) {
    var isSure: Boolean? by remember {
        mutableStateOf(null)
    }

    navigator.OnNavigationResult<Boolean>(key = "result") {
        isSure = it
        if (it) {
            IsLivanAvalible = true
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.tertiaryContainer)
    ) {
        Column(
            modifier = Modifier
                .background(
                    MaterialTheme.colorScheme.background,
                    shape = MaterialTheme.shapes.large
                )
                .padding(24.dp)
                .align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Do You Want to Open Livan ??!!!",
                style = MaterialTheme.typography.headlineSmall
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                OutlinedButton(
                    onClick = { navigator.navigateBack() }) {
                    Text(text = "No")
                }

                Spacer(modifier = Modifier.width(24.dp))

                Button(
                    onClick = {
                        navigator.navigate(GoldoonScreens.Khak.route)
                    }
                ) {
                    Text(text = "Yes")
                }
            }

            isSure?.let {
                Text(
                    text = if (it) {
                        "Unlocked"
                    } else {
                        "UR A Pussy Nigga"
                    }
                )
            }
        }
    }
}

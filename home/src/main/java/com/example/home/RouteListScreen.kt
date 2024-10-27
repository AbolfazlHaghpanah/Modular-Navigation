package com.example.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.base_ui.AppScreens
import com.example.base_ui.CommonScreens
import com.example.base_ui.Navigator

@Composable
fun RouteListScreen(navigator: Navigator) {
    var shouldShowDialog: String? by remember {
        mutableStateOf(null)
    }

    if (shouldShowDialog != null) {
        AlertDialog(
            text = {
                Text(text = shouldShowDialog.orEmpty())
            },
            onDismissRequest = { shouldShowDialog = null },
            confirmButton = { }
        )
    }

    Row(Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .clickable {
                navigator
                    .navigate(CommonScreens.BargScreen)
                    .let {
                        shouldShowDialog = it
                    }
            }
            .background(MaterialTheme.colorScheme.tertiary)
            .fillMaxHeight()
            .weight(1f)
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "Goldoon",
                color = MaterialTheme.colorScheme.onTertiary,
                style = MaterialTheme.typography.displayMedium
            )
        }

        Box(
            modifier = Modifier
                .clickable {
                    navigator
                        .navigate(CommonScreens.Ub)
                        .let {
                            shouldShowDialog = it
                        }
                }
                .background(MaterialTheme.colorScheme.secondary)
                .fillMaxHeight()
                .weight(1f),
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "Livan",
                color = MaterialTheme.colorScheme.onSecondary,
                style = MaterialTheme.typography.displayMedium
            )
        }
    }
}
package com.example.goldoon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.base_ui.Navigator

@Composable
fun KhakScreen(navigator: Navigator) {
    Column(
        Modifier
            .background(MaterialTheme.colorScheme.surface)
            .padding(24.dp)
            .navigationBarsPadding()
    ) {
        Text(
            text = "Are You SURE ??!!",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(240.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    navigator.setResultAndPop("result", true)
                }
            ) {
                Text(text = "Im Sure")
            }
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = {
                    navigator.setResultAndPop("result", false)
                }
            ) {
                Text(text = "No im not")
            }
        }
    }
}
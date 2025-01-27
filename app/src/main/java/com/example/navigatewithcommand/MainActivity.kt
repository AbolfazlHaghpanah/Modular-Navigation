package com.example.navigatewithcommand

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.navigation.ModalBottomSheetLayout
import androidx.compose.material.navigation.rememberBottomSheetNavigator
import androidx.navigation.compose.NavHost
import com.example.goldoon.navigation.goldoonNavGraph
import com.example.home.navigation.HomeScreens
import com.example.home.navigation.homeNavGraph
import com.example.livan.navigation.livanNavGraph


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val bottomSheetNavigator = rememberBottomSheetNavigator()
            val navigator = rememberNavigator(bottomSheetNavigator = bottomSheetNavigator)

            ModalBottomSheetLayout(bottomSheetNavigator) {
                NavHost(
                    navController = navigator.navController,
                    startDestination = HomeScreens
                ) {
                    homeNavGraph(navigator)
                    goldoonNavGraph(navigator)
                    livanNavGraph(navigator)
                }
            }
        }
    }
}

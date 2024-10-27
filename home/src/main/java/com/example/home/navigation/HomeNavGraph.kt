package com.example.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.base_ui.AppScreens
import com.example.base_ui.Navigator
import com.example.home.HomeScreen
import com.example.home.RouteListScreen

fun NavGraphBuilder.homeNavGraph(navigator: Navigator) {
    navigation<HomeScreens>(startDestination = HomeScreens.Home) {
        composable<HomeScreens.Home> {
            HomeScreen(navigator)
        }

        composable<HomeScreens.RouteList> {
            RouteListScreen(navigator)
        }
    }
}

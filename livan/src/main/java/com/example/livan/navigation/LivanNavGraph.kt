package com.example.livan.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.example.base_ui.Navigator
import com.example.livan.LivanResultScreen
import com.example.livan.UbScreen

fun NavGraphBuilder.livanNavGraph(navigator: Navigator) {
    navigation<LivanScreens>(startDestination = LivanScreens.Ub) {
        composable<LivanScreens.Ub> {
            UbScreen(navigator = navigator)
        }

        composable<LivanScreens.LivanResult> { backStack ->
            val result: LivanScreens.LivanResult = backStack.toRoute()
            LivanResultScreen(
                navigator = navigator,
                value = result.value
            )
        }
    }
}
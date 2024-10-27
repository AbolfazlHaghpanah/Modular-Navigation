package com.example.goldoon.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.base_ui.Navigator
import com.example.goldoon.BargScreen
import com.example.goldoon.KhakScreen
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.bottomSheet

@OptIn(ExperimentalMaterialNavigationApi::class)
fun NavGraphBuilder.goldoonNavGraph(navigator: Navigator) {
    navigation<GoldoonScreens>(startDestination = GoldoonScreens.Barg) {
        composable<GoldoonScreens.Barg> {
            BargScreen(navigator = navigator)
        }

        bottomSheet(GoldoonScreens.Khak.route) {
            KhakScreen(navigator = navigator)
        }
    }
}
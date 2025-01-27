package com.example.navigatewithcommand

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.base_ui.AppScreens
import com.example.base_ui.CommonScreens
import com.example.base_ui.IsLivanAvalible
import com.example.base_ui.Navigator
import com.example.goldoon.navigation.GoldoonScreens
import com.example.livan.navigation.LivanScreens
import androidx.compose.material.navigation.BottomSheetNavigator

class NavigatorHost(
    internal val navController: NavHostController
) : Navigator {

    override fun navigateBack() {
        navController.navigateUp()
    }

    override fun <T : AppScreens> navigate(targetScreens: T): String? {
        if (targetScreens is CommonScreens) {
            return targetScreens.onNavigate(navController)
        }
        navController.navigate(targetScreens)
        return null
    }

    override fun navigate(route: String) {
        navController.navigate(route)
    }

    override fun <T> setResultAndPop(key: String, data: T) {
        navController.previousBackStackEntry
            ?.savedStateHandle
            ?.set<T>(key, data)

        navController.navigateUp()
    }

    override fun popUpTo(targetScreens: AppScreens) {

    }

    @Composable
    override fun <T> OnNavigationResult(key: String, action: (result: T) -> Unit) {
        val backStackEntry by navController.currentBackStackEntryAsState()

        LaunchedEffect(backStackEntry) {
            backStackEntry?.let { navBackStackEntry ->
                navBackStackEntry.savedStateHandle
                    .remove<T>(key)
                    ?.let(action)
            }
        }
    }
}

@Composable
fun rememberNavigator(bottomSheetNavigator: BottomSheetNavigator): NavigatorHost {
    val navController = rememberNavController(bottomSheetNavigator)
    return NavigatorHost(navController)
}

private fun CommonScreens.onNavigate(navController: NavHostController): String? {
    return when (this) {
        is CommonScreens.BargScreen -> {
            navController.navigate(GoldoonScreens.Barg)
            null
        }

        is CommonScreens.Ub -> {
            if (IsLivanAvalible) {
                navController.navigate(LivanScreens.Ub)
                null
            } else {
                "You Should Start At Goldoon"
            }
        }
    }
}

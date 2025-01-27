package com.example.base_ui

import androidx.compose.runtime.Composable

interface Navigator {
    fun navigateBack()
    fun <T : AppScreens> navigate(targetScreens: T): String?
    fun <T> setResultAndPop(key: String, data: T)
    fun navigate(route: String)
    fun popUpTo(targetScreens: AppScreens)

    @Composable
    fun <T> OnNavigationResult(
        key: String,
        action: (result: T) -> Unit
    )
}

interface AppScreens

sealed interface CommonScreens : AppScreens {
    data object BargScreen : CommonScreens
    data object Ub : CommonScreens
}

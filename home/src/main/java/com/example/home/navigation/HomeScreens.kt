package com.example.home.navigation

import com.example.base_ui.AppScreens
import kotlinx.serialization.Serializable

@Serializable
object HomeScreens : AppScreens {
    @Serializable
    object Home : AppScreens

    @Serializable
    object RouteList : AppScreens
}

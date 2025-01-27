package com.example.livan.navigation

import com.example.base_ui.AppScreens
import kotlinx.serialization.Serializable

@Serializable
object LivanScreens : AppScreens {

    @Serializable
    data class LivanResult(val value: Int) : AppScreens

    @Serializable
    object Ub : AppScreens
}
package com.poly.assigment_kotlin.screen

sealed class Screen(val screen: String) {
    data object Home: Screen("home")
    data object Favorites: Screen("favorites")
    data object Notification: Screen("notification")
    data object Profile: Screen("profile")

}
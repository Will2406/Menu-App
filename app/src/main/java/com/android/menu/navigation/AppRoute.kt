package com.android.menu.navigation

sealed class AppRoute(
    val route: String,
    val title: String,
) {
    object Login : AppRoute(
        route = "Login",
        title = "Login"
    )
}
package com.android.menu.navigation.initial

sealed class InitialRoute(
    val route: String,
    val title: String,
) {
    object Login : InitialRoute(
        route = "Login",
        title = "Login"
    )
}
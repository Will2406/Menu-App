package com.android.menu.navigation.initial

sealed class InitialRoute(
    val route: String,
    val title: String,
) {
    object LoginScreen : InitialRoute(
        route = "LoginScreen",
        title = "LoginScreen"
    )

    object RegisterScreen : InitialRoute(
        route = "RegisterScreen",
        title = "RegisterScreen"
    )
}
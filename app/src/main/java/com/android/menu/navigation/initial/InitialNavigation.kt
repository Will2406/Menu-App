package com.android.menu.navigation.initial

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android.menu.ui.screen.login.InitLoginScreen
import com.android.menu.ui.screen.signup.InitSignUpScreen


@Composable
fun InitialNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = InitialRoute.LoginScreen.route) {
        composable(route = InitialRoute.LoginScreen.route) { InitLoginScreen(context = LocalContext.current, navController = navController) }
        composable(route = InitialRoute.RegisterScreen.route) { InitSignUpScreen(context = LocalContext.current, navController = navController) }

    }
}
package com.android.menu.navigation


import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.android.menu.screen.FoodMapScreen
import com.android.menu.screen.ProfileScreen
import com.android.menu.screen.StatsScreen
import com.android.menu.screen.food_detail.InitFoodDetailScreen
import com.android.menu.screen.home.InitHomeScreen
import com.android.menu.screen.saved.InitSavedScreen
import com.android.menu.screen.search.InitSearchScreen
import com.android.menu.R
import com.android.menu.screen.login.LoginScreen


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomBarRoute.HomeScreen.route) {
        composable(route = BottomBarRoute.HomeScreen.route) { InitHomeScreen(navController) }
        composable(route = BottomBarRoute.SearchScreen.route) { InitSearchScreen(navController) }
        composable(route = BottomBarRoute.StatsScreen.route) { StatsScreen() }
        composable(route = BottomBarRoute.SavedScreen.route) { InitSavedScreen(navController) }
        composable(route = BottomBarRoute.ProfileScreen.route) { ProfileScreen() }
        composable(
            route = BottomBarRoute.FoodDetailScreen.route,
            arguments = listOf(
                navArgument("food") {
                    type = NavType.StringType
                }
            )
        ) { InitFoodDetailScreen(navController) }
        composable(route = BottomBarRoute.FoodMapScreen.route) { FoodMapScreen() }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val listItems = listOf(
        BottomBarRoute.HomeScreen,
        BottomBarRoute.SearchScreen,
        BottomBarRoute.StatsScreen,
        BottomBarRoute.SavedScreen,
        BottomBarRoute.ProfileScreen
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        listItems.forEachIndexed { _, item ->
            NavigationBarItem(
                icon = { Icon(painter = painterResource(id = item.icon ?: R.drawable.ic_comment), contentDescription = item.title) },
                label = { Text(item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
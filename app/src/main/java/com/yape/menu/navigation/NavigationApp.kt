package com.yape.menu.navigation


import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.yape.menu.R
import com.yape.menu.screen.FoodDetailScreen
import com.yape.menu.screen.OrderScreen
import com.yape.menu.screen.ProfileScreen
import com.yape.menu.screen.SavedScreen
import com.yape.menu.screen.StatsScreen
import com.yape.menu.screen.home.InitHomeScreen


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomBarNav.HomeScreen.route) {
        composable(route = BottomBarNav.HomeScreen.route) { InitHomeScreen(navController) }
        composable(route = BottomBarNav.OrderScreen.route) { OrderScreen() }
        composable(route = BottomBarNav.StatsScreen.route) { StatsScreen() }
        composable(route = BottomBarNav.SavedScreen.route) { SavedScreen() }
        composable(route = BottomBarNav.ProfileScreen.route) { ProfileScreen() }
        composable(route = BottomBarNav.FoodDetailScreen.route) { FoodDetailScreen() }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val listItems = listOf(
        BottomBarNav.HomeScreen,
        BottomBarNav.OrderScreen,
        BottomBarNav.StatsScreen,
        BottomBarNav.SavedScreen,
        BottomBarNav.ProfileScreen
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
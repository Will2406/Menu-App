package com.yape.menu.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.yape.menu.R

sealed class BottomBarNav(
    val route: String,
    val title: String,
    var icon: Int? = null
) {

    object HomeScreen : BottomBarNav(
        route = "Home",
        title = "Home",
        icon = R.drawable.ic_home
    )

    object OrderScreen : BottomBarNav(
        route = "Order",
        title = "Order",
        icon = R.drawable.ic_order
    )

    object StatsScreen : BottomBarNav(
        route = "Stats",
        title = "Stats",
        icon = R.drawable.ic_stats
    )

    object SavedScreen : BottomBarNav(
        route = "Saved",
        title = "Saved",
        icon = R.drawable.ic_bookmark
    )

    object ProfileScreen : BottomBarNav(
        route = "Profile",
        title = "Profile",
        icon = R.drawable.ic_profile
    )

    object FoodDetailScreen : BottomBarNav(
        route = "FoodDetail",
        title = "FoodDetail"
    )
}
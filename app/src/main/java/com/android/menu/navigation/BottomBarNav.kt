package com.android.menu.navigation

import android.net.Uri
import com.android.menu.R

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

    object SearchScreen : BottomBarNav(
        route = "Search",
        title = "Search",
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
        route = "FoodDetail/{food}",
        title = "FoodDetail"
    ) {
        fun createRoot(food: String) = route.replace(
            oldValue = "{food}",
            newValue = Uri.encode(food)
        )
    }

    object FoodMapScreen : BottomBarNav(
        route = "FoodMap",
        title = "FoodMap"
    )
}
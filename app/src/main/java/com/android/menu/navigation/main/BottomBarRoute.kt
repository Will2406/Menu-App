package com.android.menu.navigation.main

import android.net.Uri
import com.android.menu.R

sealed class BottomBarRoute(
    val route: String,
    val title: String,
    var icon: Int? = null
) {

    object HomeScreen : BottomBarRoute(
        route = "Home",
        title = "Home",
        icon = R.drawable.ic_home
    )

    object SearchScreen : BottomBarRoute(
        route = "Search",
        title = "Search",
        icon = R.drawable.ic_order
    )

    object StatsScreen : BottomBarRoute(
        route = "Stats",
        title = "Stats",
        icon = R.drawable.ic_stats
    )

    object SavedScreen : BottomBarRoute(
        route = "Saved",
        title = "Saved",
        icon = R.drawable.ic_bookmark
    )

    object ProfileScreen : BottomBarRoute(
        route = "Profile",
        title = "Profile",
        icon = R.drawable.ic_profile
    )

    object FoodDetailScreen : BottomBarRoute(
        route = "FoodDetail/{food}",
        title = "FoodDetail"
    ) {
        fun createRoot(food: String) = route.replace(
            oldValue = "{food}",
            newValue = Uri.encode(food)
        )
    }

    object FoodMapScreen : BottomBarRoute(
        route = "FoodMap",
        title = "FoodMap"
    )
}
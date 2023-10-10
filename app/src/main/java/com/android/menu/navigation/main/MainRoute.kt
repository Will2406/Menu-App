package com.android.menu.navigation.main

import android.net.Uri
import com.android.menu.R

sealed class MainRoute(
    val route: String,
    val title: String,
    var icon: Int? = null
) {

    object HomeScreen : MainRoute(
        route = "Home",
        title = "Home",
        icon = R.drawable.ic_home
    )

    object SearchScreen : MainRoute(
        route = "Search",
        title = "Search",
        icon = R.drawable.ic_order
    )

    object StatsScreen : MainRoute(
        route = "Stats",
        title = "Stats",
        icon = R.drawable.ic_stats
    )

    object SavedScreen : MainRoute(
        route = "Saved",
        title = "Saved",
        icon = R.drawable.ic_bookmark
    )

    object ProfileScreen : MainRoute(
        route = "Profile",
        title = "Profile",
        icon = R.drawable.ic_profile
    )

    object FoodDetailScreen : MainRoute(
        route = "FoodDetail/{food}",
        title = "FoodDetail"
    ) {
        fun createRoot(food: String) = route.replace(
            oldValue = "{food}",
            newValue = Uri.encode(food)
        )
    }

    object FoodMapScreen : MainRoute(
        route = "FoodMap",
        title = "FoodMap"
    )
}
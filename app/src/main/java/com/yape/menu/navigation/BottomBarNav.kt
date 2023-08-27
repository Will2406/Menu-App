package com.yape.menu.navigation

import android.net.Uri
import com.yape.menu.R
import com.yape.menu.domain.TrendingFoodModel

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
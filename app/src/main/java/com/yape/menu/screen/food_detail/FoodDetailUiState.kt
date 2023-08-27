package com.yape.menu.screen.food_detail

import com.yape.menu.domain.CategoryModel
import com.yape.menu.domain.TrendingFoodModel

data class FoodDetailUiState(
    val loading: Boolean = false,
    val error: Boolean = false,
    val trendingFood: TrendingFoodModel? = null,
)
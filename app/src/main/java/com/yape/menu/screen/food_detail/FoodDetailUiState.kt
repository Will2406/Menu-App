package com.yape.menu.screen.food_detail

import com.yape.menu.domain.model.FoodModel

data class FoodDetailUiState(
    val loading: Boolean = false,
    val error: Boolean = false,
    val trendingFood: FoodModel? = null,
)
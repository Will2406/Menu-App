package com.yape.menu.screen.food_detail

import com.yape.domain.model.FoodModel


data class FoodDetailUiState(
    val loading: Boolean = false,
    val error: Boolean = false,
    val food: FoodModel? = null,
)
package com.android.menu.screen.food_detail

import com.android.menu.domain.model.FoodModel


data class FoodDetailUiState(
    val loading: Boolean = false,
    val error: Boolean = false,
    val food: FoodModel? = null,
)
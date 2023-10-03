package com.android.menu.screen.saved

import com.android.menu.domain.model.FoodModel


data class SavedUiState(
    val allFoodList: List<FoodModel> = mutableListOf()
)
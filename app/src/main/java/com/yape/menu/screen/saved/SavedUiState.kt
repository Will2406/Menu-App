package com.yape.menu.screen.saved

import com.yape.domain.model.FoodModel

data class SavedUiState(
    val allFoodList: List<FoodModel> = mutableListOf()
)
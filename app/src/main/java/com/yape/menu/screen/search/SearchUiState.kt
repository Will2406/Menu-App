package com.yape.menu.screen.search

import com.yape.domain.model.FoodModel

data class SearchUiState(
    val loading: Boolean = false,
    val error: Boolean = false,
    val allFoodList: List<FoodModel> = mutableListOf()
)
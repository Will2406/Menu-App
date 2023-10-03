package com.android.menu.screen.search

import com.android.menu.domain.model.FoodModel


data class SearchUiState(
    val loading: Boolean = false,
    val error: Boolean = false,
    val allFoodList: List<FoodModel> = mutableListOf()
)
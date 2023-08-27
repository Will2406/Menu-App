package com.yape.menu.screen.home

import com.yape.menu.domain.model.CategoryModel
import com.yape.menu.domain.model.TrendingFoodModel

data class HomeUiState(
    val loading: Boolean = false,
    val error: Boolean = false,
    val categoryList: List<CategoryModel> = mutableListOf(),
    val foodTrendingList: List<TrendingFoodModel> = mutableListOf()
)
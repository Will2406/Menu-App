package com.yape.menu.screen.home

import com.yape.domain.model.CategoryModel
import com.yape.domain.model.FoodModel

data class HomeUiState(
    val isCategoryLoading: Boolean = false,
    val isFoodTrendingLoading:Boolean = false,
    val error: Boolean = false,
    val categoryList: List<CategoryModel> = mutableListOf(),
    val foodTrendingList: List<FoodModel> = mutableListOf()
)
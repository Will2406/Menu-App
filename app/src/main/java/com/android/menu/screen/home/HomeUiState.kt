package com.android.menu.screen.home

import com.android.menu.domain.model.CategoryModel
import com.android.menu.domain.model.FoodModel


data class HomeUiState(
    val isCategoryLoading: Boolean = false,
    val isFoodTrendingLoading:Boolean = false,
    val error: Boolean = false,
    val categoryList: List<CategoryModel> = mutableListOf(),
    val foodTrendingList: List<FoodModel> = mutableListOf()
)
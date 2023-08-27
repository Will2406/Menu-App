package com.yape.menu.screen.home

import com.yape.menu.data.CategoryModel

data class HomeUiState(
    val loading: Boolean = false,
    val error: Boolean = false,
    val categoryList: List<CategoryModel> = mutableListOf()
)
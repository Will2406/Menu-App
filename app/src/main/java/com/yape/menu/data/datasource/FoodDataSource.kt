package com.yape.menu.data.datasource

import com.yape.menu.data.generics.DataResult
import com.yape.menu.data.response.CategoryListResponse
import com.yape.menu.data.response.TrendingFoodListResponse

interface FoodRemoteDataSource {
    suspend fun getTrendingFood(): DataResult<TrendingFoodListResponse>
}

interface FoodLocalDataSource {
}
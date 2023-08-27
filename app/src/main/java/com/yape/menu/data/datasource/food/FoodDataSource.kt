package com.yape.menu.data.datasource.food

import com.yape.menu.data.core.generics.DataResult
import com.yape.menu.data.core.response.TrendingFoodListResponse

interface FoodRemoteDataSource {
    suspend fun getTrendingFood(): DataResult<TrendingFoodListResponse>
}

interface FoodLocalDataSource {
}
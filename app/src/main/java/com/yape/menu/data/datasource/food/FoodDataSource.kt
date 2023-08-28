package com.yape.menu.data.datasource.food

import com.yape.menu.data.core.generics.DataResult
import com.yape.menu.data.core.response.FoodListResponse
import com.yape.menu.data.core.response.TrendingFoodListResponse

interface FoodRemoteDataSource {
    suspend fun getTrendingFood(): DataResult<TrendingFoodListResponse>
    suspend fun getAllFood():DataResult<FoodListResponse>
}

interface FoodLocalDataSource {
}
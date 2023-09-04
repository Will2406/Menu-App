package com.yape.data.datasource.food

import com.yape.data.core.DataResult
import com.yape.data.remote.model.FoodListResponse
import com.yape.data.remote.model.TrendingFoodListResponse


interface FoodRemoteDataSource {
    suspend fun getTrendingFood(): DataResult<TrendingFoodListResponse>
    suspend fun getAllFood(): DataResult<FoodListResponse>
}

interface FoodLocalDataSource {

}
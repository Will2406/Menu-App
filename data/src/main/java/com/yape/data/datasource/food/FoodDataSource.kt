package com.yape.data.datasource.food

import com.yape.data.core.DataResult
import com.yape.data.local.FoodEntity
import com.yape.data.remote.model.FoodListResponse
import com.yape.data.remote.model.TrendingFoodListResponse


interface FoodRemoteDataSource {
    suspend fun getTrending(): DataResult<TrendingFoodListResponse>
    suspend fun getAll(): DataResult<FoodListResponse>
}

interface FoodLocalDataSource {
    suspend fun getAll(): List<FoodEntity>
    suspend fun save(entity: FoodEntity)
    suspend fun get(id: String): FoodEntity?
    suspend fun delete(food: FoodEntity)
}
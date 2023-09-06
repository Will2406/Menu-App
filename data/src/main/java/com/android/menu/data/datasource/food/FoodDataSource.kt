package com.android.menu.data.datasource.food

import com.android.menu.data.core.DataResult
import com.android.menu.data.local.FoodEntity
import com.android.menu.data.remote.model.FoodListResponse
import com.android.menu.data.remote.model.FoodResponse
import kotlinx.coroutines.flow.Flow


interface FoodRemoteDataSource {
    suspend fun getTrending(): Flow<List<FoodResponse?>>
    suspend fun getAll(): DataResult<FoodListResponse>
}

interface FoodLocalDataSource {
    suspend fun getAll(): List<FoodEntity>
    suspend fun save(entity: FoodEntity)
    suspend fun get(id: String): FoodEntity?
    suspend fun delete(food: FoodEntity)
}
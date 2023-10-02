package com.android.menu.data.datasource.food

import com.android.menu.data.local.database.FoodEntity
import com.android.menu.data.remote.model.FoodResponse
import kotlinx.coroutines.flow.Flow


interface FoodRemoteDataSource {
    suspend fun getTrending(): Flow<List<FoodResponse?>>
    suspend fun getAll(): Flow<List<FoodResponse?>>
}

interface FoodLocalDataSource {
    suspend fun getAll(): List<FoodEntity>
    suspend fun save(entity: FoodEntity)
    suspend fun get(id: String): FoodEntity?
    suspend fun delete(food: FoodEntity)
}
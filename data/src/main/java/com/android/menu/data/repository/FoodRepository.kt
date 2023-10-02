package com.android.menu.data.repository

import com.android.menu.data.datasource.food.FoodRemoteDataSource
import com.android.menu.data.datasource.food.FoodLocalDataSource
import com.android.menu.data.local.database.FoodEntity
import com.android.menu.data.remote.model.FoodResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

class FoodRepository @Inject constructor(
    private val remote: FoodRemoteDataSource,
    private val local: FoodLocalDataSource
) {

    suspend fun getFoodTrendingList(): Flow<List<FoodResponse?>> = remote.getTrending()

    suspend fun getAllFoodList(): Flow<List<FoodResponse?>> = remote.getAll()


    suspend fun getAllStoredFoodList(): Flow<List<FoodEntity>> = supervisorScope {
        flow { emit(local.getAll()) }
    }

    suspend fun saveFoodInStorage(food: FoodEntity) {
        local.save(food)
    }

    suspend fun checkIfFoodIsSaved(id: String): Flow<Boolean> = supervisorScope {
        flow { emit(local.get(id) != null) }
    }

    suspend fun deleteFoodStored(food: FoodEntity) {
        local.delete(food)
    }
}
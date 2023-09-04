package com.android.menu.data.repository

import com.android.menu.data.datasource.food.FoodRemoteDataSource
import com.android.menu.data.core.DataResult
import com.android.menu.data.datasource.food.FoodLocalDataSource
import com.android.menu.data.local.FoodEntity
import com.android.menu.data.remote.model.FoodResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

class FoodRepository @Inject constructor(
    private val remote: FoodRemoteDataSource,
    private val local: FoodLocalDataSource
) {

    suspend fun getFoodTrendingList(): Flow<List<FoodResponse>> = supervisorScope {
        when (val result = remote.getTrending()) {
            is DataResult.Success ->
                flow {
                    emit(result.data.trendingFoodList)
                }

            is DataResult.Error -> throw Error()

        }
    }

    suspend fun getAllFoodList(): Flow<List<FoodResponse>> = supervisorScope {
        when (val result = remote.getAll()) {
            is DataResult.Success ->
                flow {
                    emit(result.data.foodList)
                }

            is DataResult.Error -> throw Error()

        }
    }

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
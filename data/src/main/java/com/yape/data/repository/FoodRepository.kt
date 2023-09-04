package com.yape.data.repository

import com.yape.data.datasource.food.FoodRemoteDataSource
import com.yape.data.core.DataResult
import com.yape.data.remote.model.FoodResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

class FoodRepository @Inject constructor(private val remote: FoodRemoteDataSource) {

    suspend fun getFoodTrendingList(): Flow<List<FoodResponse>> = supervisorScope {
        when (val result = remote.getTrendingFood()) {
            is DataResult.Success ->
                flow {
                    emit(result.data.trendingFoodList)
                }

            is DataResult.Error -> throw Error()

        }
    }

    suspend fun getAllFoodList(): Flow<List<FoodResponse>> = supervisorScope {
        when (val result = remote.getAllFood()) {
            is DataResult.Success ->
                flow {
                    emit(result.data.foodList)
                }

            is DataResult.Error -> throw Error()

        }
    }
}
package com.yape.menu.data.repository

import com.yape.menu.data.datasource.food.FoodRemoteDataSource
import com.yape.menu.data.core.generics.DataResult
import com.yape.menu.domain.model.TrendingFoodModel
import com.yape.menu.domain.model.convertToModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

class FoodRepository @Inject constructor(private val remote: FoodRemoteDataSource) {

    suspend fun getFoodTrendingList(): Flow<List<TrendingFoodModel>> = supervisorScope {
        when (val result = remote.getTrendingFood()) {
            is DataResult.Success ->
                flow {
                    emit(result.data.trendingFoodList)
                }.map { it.convertToModel() }

            is DataResult.Error -> throw Error()

        }
    }
}
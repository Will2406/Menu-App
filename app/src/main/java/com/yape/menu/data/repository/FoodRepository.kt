package com.yape.menu.data.repository

import com.yape.menu.data.datasource.FoodRemoteDataSource
import com.yape.menu.data.generics.DataResult
import com.yape.menu.domain.CategoryModel
import com.yape.menu.domain.TrendingFoodModel
import com.yape.menu.domain.convertToModel
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
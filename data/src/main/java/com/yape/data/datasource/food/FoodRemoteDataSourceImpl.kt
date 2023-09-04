package com.yape.data.datasource.food


import com.yape.data.remote.MenuService
import com.yape.data.core.DataResult
import com.yape.data.core.safeApiCall
import com.yape.data.remote.model.FoodListResponse
import com.yape.data.remote.model.TrendingFoodListResponse
import javax.inject.Inject

class FoodRemoteDataSourceImpl @Inject constructor(private val api: MenuService) : FoodRemoteDataSource {

    override suspend fun getTrendingFood(): DataResult<TrendingFoodListResponse> {
        return safeApiCall { api.getTrendingFood() }
    }

    override suspend fun getAllFood(): DataResult<FoodListResponse> {
        return safeApiCall { api.getAllFood() }
    }
}
package com.yape.menu.data.datasource.food

import com.yape.menu.data.core.MenuService
import com.yape.menu.data.core.generics.DataResult
import com.yape.menu.data.core.generics.safeApiCall
import com.yape.menu.data.core.response.FoodListResponse
import com.yape.menu.data.core.response.TrendingFoodListResponse
import javax.inject.Inject

class FoodRemoteDataSourceImpl @Inject constructor(private val api: MenuService) : FoodRemoteDataSource {

    override suspend fun getTrendingFood(): DataResult<TrendingFoodListResponse> {
        return safeApiCall { api.getTrendingFood() }
    }

    override suspend fun getAllFood(): DataResult<FoodListResponse> {
        return safeApiCall { api.getAllFood() }
    }
}
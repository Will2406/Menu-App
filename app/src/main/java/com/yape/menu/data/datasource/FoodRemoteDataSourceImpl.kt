package com.yape.menu.data.datasource

import com.yape.menu.data.MenuService
import com.yape.menu.data.generics.DataResult
import com.yape.menu.data.generics.safeApiCall
import com.yape.menu.data.response.TrendingFoodListResponse
import javax.inject.Inject

class FoodRemoteDataSourceImpl @Inject constructor(private val api: MenuService) : FoodRemoteDataSource {

    override suspend fun getTrendingFood(): DataResult<TrendingFoodListResponse> {
        return safeApiCall { api.getTrendingFood() }
    }
}
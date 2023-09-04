package com.android.menu.data.datasource.food


import com.android.menu.data.remote.MenuService
import com.android.menu.data.core.DataResult
import com.android.menu.data.core.safeApiCall
import com.android.menu.data.remote.model.FoodListResponse
import com.android.menu.data.remote.model.TrendingFoodListResponse
import javax.inject.Inject

class FoodRemoteDataSourceImpl @Inject constructor(
    private val api: MenuService
) : FoodRemoteDataSource {

    override suspend fun getTrending(): DataResult<TrendingFoodListResponse> {
        return safeApiCall { api.getTrendingFood() }
    }

    override suspend fun getAll(): DataResult<FoodListResponse> {
        return safeApiCall { api.getAllFood() }
    }
}
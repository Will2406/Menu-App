package com.android.menu.data.remote

import com.android.menu.data.remote.model.CategoryListResponse
import com.android.menu.data.remote.model.FoodListResponse
import com.android.menu.data.remote.model.TrendingFoodListResponse
import retrofit2.Response
import retrofit2.http.GET

interface MenuService {

    @GET("categories")
    suspend fun getCategories(): Response<CategoryListResponse>

    @GET("trending")
    suspend fun getTrendingFood(): Response<TrendingFoodListResponse>

    @GET("food")
    suspend fun getAllFood(): Response<FoodListResponse>
}
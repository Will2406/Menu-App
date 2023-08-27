package com.yape.menu.data.core

import com.yape.menu.data.core.response.CategoryListResponse
import com.yape.menu.data.core.response.TrendingFoodListResponse
import retrofit2.Response
import retrofit2.http.GET

interface MenuService {

    @GET("categories")
    suspend fun getCategories(): Response<CategoryListResponse>

    @GET("trending")
    suspend fun getTrendingFood(): Response<TrendingFoodListResponse>
}
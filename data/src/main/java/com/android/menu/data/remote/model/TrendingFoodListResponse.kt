package com.android.menu.data.remote.model

import com.squareup.moshi.Json

data class TrendingFoodListResponse(
    @field:Json(name = "message") val message: String? = "",
    @field:Json(name = "data") val trendingFoodList: List<FoodResponse>,
)

data class FoodResponse(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "rating") val rating: String,
    @field:Json(name = "attributes") val attributes: List<String>,
    @field:Json(name = "imageUrl") val imageUrl: String,
    @field:Json(name = "price") val price: String,
    @field:Json(name = "category") val category: List<String>,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "ingredientList") val ingredientList: List<IngredientResponse>,
    @field:Json(name = "createAt") val createAt: Long,
    @field:Json(name = "updatedAt") val updatedAt: Long
)


data class IngredientResponse(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "calories") val calories: String,
)
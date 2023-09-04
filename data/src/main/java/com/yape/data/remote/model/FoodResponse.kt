package com.yape.data.remote.model

import com.squareup.moshi.Json

data class FoodListResponse(
    @field:Json(name = "message") val message: String? = "",
    @field:Json(name = "data") val foodList: List<FoodResponse>,
)
package com.android.menu.data.remote.model

import com.squareup.moshi.Json

data class CategoryListResponse(
    @field:Json(name = "message") val message: String? = "",
    @field:Json(name = "data") val categoryList: List<CategoryResponse>,
)

data class CategoryResponse(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "image_url") val imageUrl: String,
    @field:Json(name = "created_at") val createdAt: Long,
    @field:Json(name = "updated_at") val updatedAt: Long,
)
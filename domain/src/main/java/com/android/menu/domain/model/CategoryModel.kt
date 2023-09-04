package com.android.menu.domain.model

import com.android.menu.data.remote.model.CategoryResponse


data class CategoryModel(var id: String, var name: String, var image: String)

fun CategoryResponse.convertToModel() = CategoryModel(
    id = id,
    name = name,
    image = imageUrl
)

fun List<CategoryResponse>.convertToModel() = map(CategoryResponse::convertToModel)
package com.yape.menu.data

import com.yape.menu.data.response.CategoryResponse

data class CategoryModel(var id: String, var name: String, var image: String)

fun CategoryResponse.convertToModel() = CategoryModel(
    id = id,
    name = name,
    image = imageUrl
)

fun List<CategoryResponse>.convertToModel() = map(CategoryResponse::convertToModel)
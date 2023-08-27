package com.yape.menu.domain.model

import com.yape.menu.data.core.response.IngredientResponse
import com.yape.menu.data.core.response.TrendingFoodResponse

data class TrendingFoodModel(
    var id: String,
    var name: String,
    var rating: String,
    var reviewers: String,
    var calories: String,
    var image: String,
    var price: String,
    var description: String,
    var ingredientList: List<IngredientResponse>
)


fun TrendingFoodResponse.convertToModel() = TrendingFoodModel(
    id = id,
    name = name,
    image = imageUrl,
    calories = attributes.get(1),
    reviewers = attributes.get(0),
    rating = rating,
    price = price,
    description = description,
    ingredientList = ingredientList
)

fun List<TrendingFoodResponse>.convertToModel() = map(TrendingFoodResponse::convertToModel)
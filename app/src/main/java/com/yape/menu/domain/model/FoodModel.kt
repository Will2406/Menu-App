package com.yape.menu.domain.model

import com.yape.menu.data.core.response.FoodResponse
import com.yape.menu.data.core.response.IngredientResponse

data class FoodModel(
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


fun FoodResponse.convertToModel() = FoodModel(
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

fun List<FoodResponse>.convertToModel() = map(FoodResponse::convertToModel)
package com.yape.domain.model


import com.yape.data.local.FoodEntity
import com.yape.data.remote.model.FoodResponse
import com.yape.data.remote.model.IngredientResponse

data class FoodModel(
    var id: String,
    var name: String,
    var rating: String,
    var reviewers: String,
    var calories: String,
    var image: String,
    var isSaved: Boolean = false,
    var price: String,
    var description: String,
    var ingredientList: List<IngredientModel>
)

fun FoodModel.convertToEntity() = FoodEntity(
    uid = id,
    name = name,
    image = image,
    isSaved = isSaved,
    calories = calories,
    reviewers = reviewers,
    rating = rating,
    price = price,
    description = description,
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
    ingredientList = ingredientList.convertToModel()
)

fun FoodEntity.convertToModel() = FoodModel(
    id = uid,
    name = name,
    image = image,
    calories = calories,
    reviewers = reviewers,
    rating = rating,
    price = price,
    description = description,
    ingredientList = mutableListOf()
)

fun List<FoodEntity>.convertLocalToModel() = map(FoodEntity::convertToModel)

fun List<FoodResponse>.convertRemoteToModel() = map(FoodResponse::convertToModel)
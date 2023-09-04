package com.yape.domain.model

import com.yape.data.remote.model.IngredientResponse


data class IngredientModel(
    val name: String,
    val calories: String,
)

fun IngredientResponse.convertToModel() = IngredientModel(
    name = name,
    calories = calories
)

fun List<IngredientResponse>.convertToModel() = map(IngredientResponse::convertToModel)
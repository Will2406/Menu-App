package com.android.menu.domain.model

import com.android.menu.data.remote.model.IngredientResponse


data class IngredientModel(
    val name: String,
    val calories: String,
)

fun IngredientResponse.convertToModel() = IngredientModel(
    name = name,
    calories = calories
)

fun List<IngredientResponse>.convertToModel() = map(IngredientResponse::convertToModel)
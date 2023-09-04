package com.yape.domain.usecase

import com.yape.data.repository.FoodRepository
import com.yape.domain.core.UseCase
import com.yape.domain.model.FoodModel
import com.yape.domain.model.convertToEntity
import javax.inject.Inject

class SaveFoodInStorage @Inject constructor(
    private val repository: FoodRepository
) : UseCase.WithoutResult<FoodModel> {

    override suspend fun invoke(params: FoodModel) {
        repository.saveFoodInStorage(params.convertToEntity())
    }
}
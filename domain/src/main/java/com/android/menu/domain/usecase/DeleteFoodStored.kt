package com.android.menu.domain.usecase

import com.android.menu.data.repository.FoodRepository
import com.android.menu.domain.core.UseCase
import com.android.menu.domain.model.FoodModel
import com.android.menu.domain.model.convertToEntity
import javax.inject.Inject


class DeleteFoodStored @Inject constructor(
    private val repository: FoodRepository
) : UseCase.WithoutResult<FoodModel> {

    override suspend fun invoke(params: FoodModel) {
        repository.deleteFoodStored(params.convertToEntity())
    }
}
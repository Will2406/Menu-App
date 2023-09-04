package com.yape.domain.usecase

import com.yape.data.repository.FoodRepository
import com.yape.domain.model.FoodModel
import com.yape.domain.model.convertToModel
import com.yape.domain.core.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAllFoodList @Inject constructor(
    private val repository: FoodRepository
) : UseCase.WithoutParams<Flow<List<FoodModel>>> {

    override suspend fun invoke(): Flow<List<FoodModel>> {
        return repository.getAllFoodList().map { it.convertToModel() }
    }
}
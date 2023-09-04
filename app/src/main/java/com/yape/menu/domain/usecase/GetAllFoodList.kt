package com.yape.menu.domain.usecase

import com.yape.data.repository.FoodRepository
import com.yape.menu.domain.model.FoodModel
import com.yape.menu.domain.model.convertToModel
import com.yape.menu.domain.util.UseCase
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
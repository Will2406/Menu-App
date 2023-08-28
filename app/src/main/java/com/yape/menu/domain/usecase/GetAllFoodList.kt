package com.yape.menu.domain.usecase

import com.yape.menu.data.repository.FoodRepository
import com.yape.menu.domain.model.FoodModel
import com.yape.menu.domain.util.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllFoodList @Inject constructor(
    private val repository: FoodRepository
) : UseCase.WithoutParams<Flow<List<FoodModel>>> {

    override suspend fun invoke(): Flow<List<FoodModel>> {
        return repository.getAllFoodList()
    }
}
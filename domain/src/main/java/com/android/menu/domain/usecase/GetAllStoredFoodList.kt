package com.android.menu.domain.usecase

import com.android.menu.data.repository.FoodRepository
import com.android.menu.domain.model.FoodModel
import com.android.menu.domain.core.UseCase
import com.android.menu.domain.model.convertLocalToModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class GetAllStoredFoodList @Inject constructor(
    private val repository: FoodRepository
) : UseCase.WithoutParams<Flow<List<FoodModel>>> {

    override suspend fun invoke(): Flow<List<FoodModel>> {
        return repository.getAllStoredFoodList().map { it.convertLocalToModel() }
    }
}
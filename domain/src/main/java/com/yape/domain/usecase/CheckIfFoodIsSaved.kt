package com.yape.domain.usecase

import com.yape.data.repository.FoodRepository
import com.yape.domain.core.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CheckIfFoodIsSaved @Inject constructor(
    private val repository: FoodRepository
) : UseCase.WithParams<String, Flow<Boolean>> {

    override suspend fun invoke(params: String): Flow<Boolean> {
        return repository.checkIfFoodIsSaved(params)
    }
}
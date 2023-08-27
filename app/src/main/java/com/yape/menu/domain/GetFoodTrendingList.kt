package com.yape.menu.domain

import com.yape.menu.data.repository.CategoryRepository
import com.yape.menu.data.repository.FoodRepository
import com.yape.menu.domain.util.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFoodTrendingList @Inject constructor(
    private val repository: FoodRepository
) : UseCase.WithoutParams<Flow<List<TrendingFoodModel>>> {

    override suspend fun invoke(): Flow<List<TrendingFoodModel>> {
        return repository.getFoodTrendingList()
    }
}
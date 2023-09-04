package com.yape.domain.usecase

import com.yape.data.repository.CategoryRepository
import com.yape.domain.model.CategoryModel
import com.yape.domain.model.convertToModel
import com.yape.domain.core.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCategoryList @Inject constructor(
    private val repository: CategoryRepository
) : UseCase.WithoutParams<Flow<List<CategoryModel>>> {

    override suspend fun invoke(): Flow<List<CategoryModel>> {
        return repository.getCategoryList().map { it.convertToModel() }
    }
}
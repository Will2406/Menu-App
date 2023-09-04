package com.yape.menu.domain.usecase

import com.yape.data.repository.CategoryRepository
import com.yape.menu.domain.model.CategoryModel
import com.yape.menu.domain.model.convertToModel
import com.yape.menu.domain.util.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCategoryList @Inject constructor(private val repository: CategoryRepository) : UseCase.WithoutParams<Flow<List<CategoryModel>>> {

    override suspend fun invoke(): Flow<List<CategoryModel>> {
        return repository.getCategoryList().map { it.convertToModel() }
    }
}
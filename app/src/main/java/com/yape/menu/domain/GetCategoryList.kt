package com.yape.menu.domain

import com.yape.menu.data.repository.CategoryRepository
import com.yape.menu.domain.util.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoryList @Inject constructor(private val repository: CategoryRepository) : UseCase.WithoutParams<Flow<List<CategoryModel>>> {

    override suspend fun invoke(): Flow<List<CategoryModel>> {
        return repository.getCategoryList()
    }
}
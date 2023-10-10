package com.android.menu.domain.usecase

import com.android.menu.data.repository.CategoryRepository
import com.android.menu.domain.model.CategoryModel
import com.android.menu.domain.model.convertToModel
import com.android.menu.domain.core.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class GetCategoryList @Inject constructor(
    private val repository: CategoryRepository
) : UseCase.WithoutParams<Flow<List<CategoryModel>>> {

    override suspend fun invoke(): Flow<List<CategoryModel>> {
        return repository.getCategoryList().map { categoryList ->
            categoryList.map { it?.convertToModel() ?: CategoryModel() }
        }
    }
}
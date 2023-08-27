package com.yape.menu.data.repository

import com.yape.menu.domain.model.CategoryModel
import com.yape.menu.domain.model.convertToModel
import com.yape.menu.data.datasource.category.CategoryRemoteDataSource
import com.yape.menu.data.core.generics.DataResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val remote: CategoryRemoteDataSource
) {

    suspend fun getCategoryList(): Flow<List<CategoryModel>> = supervisorScope {
        when (val result = remote.getCategoryList()) {
            is DataResult.Success ->
                flow {
                    emit(result.data.categoryList)
                }.map { it.convertToModel() }

            is DataResult.Error -> throw Error()

        }
    }
}
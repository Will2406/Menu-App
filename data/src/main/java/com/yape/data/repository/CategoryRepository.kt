package com.yape.data.repository

import com.yape.data.datasource.category.CategoryRemoteDataSource
import com.yape.data.core.DataResult
import com.yape.data.remote.model.CategoryResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val remote: CategoryRemoteDataSource
) {

    suspend fun getCategoryList(): Flow<List<CategoryResponse>> = supervisorScope {
        when (val result = remote.getCategoryList()) {
            is DataResult.Success ->
                flow {
                    emit(result.data.categoryList)
                }

            is DataResult.Error -> throw Error()

        }
    }
}
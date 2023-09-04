package com.android.menu.data.repository

import com.android.menu.data.datasource.category.CategoryRemoteDataSource
import com.android.menu.data.core.DataResult
import com.android.menu.data.remote.model.CategoryResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val remote: CategoryRemoteDataSource
) {

    suspend fun getCategoryList(): Flow<List<CategoryResponse>> = supervisorScope {
        when (val result = remote.getAll()) {
            is DataResult.Success ->
                flow {
                    emit(result.data.categoryList)
                }

            is DataResult.Error -> throw Error()

        }
    }
}
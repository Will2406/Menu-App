package com.yape.data.datasource.category


import com.yape.data.remote.MenuService
import com.yape.data.core.DataResult
import com.yape.data.core.safeApiCall
import com.yape.data.remote.model.CategoryListResponse
import javax.inject.Inject

class CategoryRemoteDataSourceImpl @Inject constructor(private val api: MenuService) : CategoryRemoteDataSource {

    override suspend fun getAll(): DataResult<CategoryListResponse> {
        return safeApiCall { api.getCategories() }
    }

}
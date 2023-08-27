package com.yape.menu.data.datasource

import com.yape.menu.data.MenuService
import com.yape.menu.data.generics.DataResult
import com.yape.menu.data.generics.safeApiCall
import com.yape.menu.data.response.CategoryListResponse
import javax.inject.Inject

class CategoryRemoteDataSourceImpl @Inject constructor(private val api: MenuService) : CategoryRemoteDataSource {

    override suspend fun getCategoryList(): DataResult<CategoryListResponse> {
        return safeApiCall { api.getCategories() }
    }

}
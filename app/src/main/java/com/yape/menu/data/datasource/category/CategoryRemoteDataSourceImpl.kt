package com.yape.menu.data.datasource.category

import com.yape.menu.data.core.MenuService
import com.yape.menu.data.core.generics.DataResult
import com.yape.menu.data.core.generics.safeApiCall
import com.yape.menu.data.core.response.CategoryListResponse
import javax.inject.Inject

class CategoryRemoteDataSourceImpl @Inject constructor(private val api: MenuService) : CategoryRemoteDataSource {

    override suspend fun getCategoryList(): DataResult<CategoryListResponse> {
        return safeApiCall { api.getCategories() }
    }

}
package com.android.menu.data.datasource.category


import com.android.menu.data.remote.MenuService
import com.android.menu.data.core.DataResult
import com.android.menu.data.core.safeApiCall
import com.android.menu.data.remote.model.CategoryListResponse
import javax.inject.Inject

class CategoryRemoteDataSourceImpl @Inject constructor(private val api: MenuService) : CategoryRemoteDataSource {

    override suspend fun getAll(): DataResult<CategoryListResponse> {
        return safeApiCall { api.getCategories() }
    }

}
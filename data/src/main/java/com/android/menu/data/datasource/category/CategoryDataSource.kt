package com.android.menu.data.datasource.category


import com.android.menu.data.core.DataResult
import com.android.menu.data.remote.model.CategoryListResponse

interface CategoryRemoteDataSource {
    suspend fun getAll(): DataResult<CategoryListResponse>
}

interface CategoryLocalDataSource {

}
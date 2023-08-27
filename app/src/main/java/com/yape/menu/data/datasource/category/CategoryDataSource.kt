package com.yape.menu.data.datasource.category

import com.yape.menu.data.core.generics.DataResult
import com.yape.menu.data.core.response.CategoryListResponse

interface CategoryRemoteDataSource {
    suspend fun getCategoryList(): DataResult<CategoryListResponse>
}

interface CategoryLocalDataSource {
}
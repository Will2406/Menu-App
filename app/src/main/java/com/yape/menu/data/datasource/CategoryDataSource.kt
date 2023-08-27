package com.yape.menu.data.datasource

import com.yape.menu.data.generics.DataResult
import com.yape.menu.data.response.CategoryListResponse

interface CategoryRemoteDataSource {
    suspend fun getCategoryList(): DataResult<CategoryListResponse>
}

interface CategoryLocalDataSource {
}
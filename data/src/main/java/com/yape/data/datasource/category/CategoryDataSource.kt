package com.yape.data.datasource.category


import com.yape.data.core.DataResult
import com.yape.data.remote.model.CategoryListResponse

interface CategoryRemoteDataSource {
    suspend fun getAll(): DataResult<CategoryListResponse>
}

interface CategoryLocalDataSource {

}
package com.android.menu.data.datasource.category


import com.android.menu.data.remote.model.CategoryResponse
import kotlinx.coroutines.flow.Flow

interface CategoryRemoteDataSource {
    suspend fun getAll(): Flow<List<CategoryResponse?>>
}

interface CategoryLocalDataSource {

}
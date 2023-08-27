package com.yape.menu.data

import com.yape.menu.data.datasource.CategoryRemoteDataSource
import com.yape.menu.data.datasource.CategoryRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataSourceDI {

    @Provides
    fun createCategoryRemoteDataSource(api: MenuService): CategoryRemoteDataSource = CategoryRemoteDataSourceImpl(api)
}
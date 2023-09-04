package com.yape.data.di

import com.yape.data.datasource.category.CategoryRemoteDataSource
import com.yape.data.datasource.category.CategoryRemoteDataSourceImpl
import com.yape.data.datasource.food.FoodLocalDataSource
import com.yape.data.datasource.food.FoodLocalDataSourceImpl
import com.yape.data.datasource.food.FoodRemoteDataSource
import com.yape.data.datasource.food.FoodRemoteDataSourceImpl
import com.yape.data.local.MenuDatabase
import com.yape.data.remote.MenuService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    fun createCategoryRemoteDataSource(api: MenuService): CategoryRemoteDataSource =
        CategoryRemoteDataSourceImpl(api)

    @Provides
    fun createFoodRemoteDataSource(api: MenuService): FoodRemoteDataSource =
        FoodRemoteDataSourceImpl(api)

    @Provides
    fun createFoodLocalDataSource(database: MenuDatabase): FoodLocalDataSource =
        FoodLocalDataSourceImpl(database)
}
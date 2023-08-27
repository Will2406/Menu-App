package com.yape.menu.data.di

import com.yape.menu.data.datasource.category.CategoryRemoteDataSource
import com.yape.menu.data.datasource.category.CategoryRemoteDataSourceImpl
import com.yape.menu.data.datasource.food.FoodRemoteDataSource
import com.yape.menu.data.datasource.food.FoodRemoteDataSourceImpl
import com.yape.menu.data.core.MenuService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    fun createCategoryRemoteDataSource(api: MenuService): CategoryRemoteDataSource = CategoryRemoteDataSourceImpl(api)

    @Provides
    fun createFoodRemoteDataSource(api: MenuService): FoodRemoteDataSource = FoodRemoteDataSourceImpl(api)
}
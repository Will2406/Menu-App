package com.android.menu.data.di

import com.android.menu.data.datasource.category.CategoryRemoteDataSource
import com.android.menu.data.datasource.category.CategoryRemoteDataSourceImpl
import com.android.menu.data.datasource.food.FoodLocalDataSource
import com.android.menu.data.datasource.food.FoodLocalDataSourceImpl
import com.android.menu.data.datasource.food.FoodRemoteDataSource
import com.android.menu.data.datasource.food.FoodRemoteDataSourceImpl
import com.android.menu.data.local.MenuDatabase
import com.android.menu.data.remote.MenuService
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
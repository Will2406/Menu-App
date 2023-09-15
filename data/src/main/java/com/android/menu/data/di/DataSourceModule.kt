package com.android.menu.data.di

import com.android.menu.data.datasource.category.CategoryRemoteDataSource
import com.android.menu.data.datasource.category.CategoryRemoteDataSourceImpl
import com.android.menu.data.datasource.food.FoodLocalDataSource
import com.android.menu.data.datasource.food.FoodLocalDataSourceImpl
import com.android.menu.data.datasource.food.FoodRemoteDataSource
import com.android.menu.data.datasource.food.FoodRemoteDataSourceImpl
import com.android.menu.data.local.MenuDatabase
import com.android.menu.data.remote.MenuService
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    fun createCategoryRemoteDataSource(): CategoryRemoteDataSource =
        CategoryRemoteDataSourceImpl(FirebaseFirestore.getInstance())

    @Provides
    fun createFoodRemoteDataSource(api: MenuService): FoodRemoteDataSource =
        FoodRemoteDataSourceImpl(api, FirebaseFirestore.getInstance())

    @Provides
    fun createFoodLocalDataSource(database: MenuDatabase): FoodLocalDataSource =
        FoodLocalDataSourceImpl(database)
}
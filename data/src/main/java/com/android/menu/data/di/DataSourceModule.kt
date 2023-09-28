package com.android.menu.data.di

import android.content.Context
import com.android.menu.data.datasource.category.CategoryRemoteDataSource
import com.android.menu.data.datasource.category.CategoryRemoteDataSourceImpl
import com.android.menu.data.datasource.food.FoodLocalDataSource
import com.android.menu.data.datasource.food.FoodLocalDataSourceImpl
import com.android.menu.data.datasource.food.FoodRemoteDataSource
import com.android.menu.data.datasource.food.FoodRemoteDataSourceImpl
import com.android.menu.data.datasource.user.UserRemoteDataSource
import com.android.menu.data.datasource.user.UserRemoteDataSourceImpl
import com.android.menu.data.local.MenuDatabase
import com.android.menu.data.remote.MenuService
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    fun createCategoryRemoteDataSource(): CategoryRemoteDataSource =
        CategoryRemoteDataSourceImpl(FirebaseFirestore.getInstance())

    @Provides
    fun createFoodRemoteDataSource(): FoodRemoteDataSource =
        FoodRemoteDataSourceImpl(FirebaseFirestore.getInstance())

    @Provides
    fun createUserRemoteDataSource(@ApplicationContext context: Context): UserRemoteDataSource =
        UserRemoteDataSourceImpl(context, Firebase.auth)

    @Provides
    fun createFoodLocalDataSource(database: MenuDatabase): FoodLocalDataSource =
        FoodLocalDataSourceImpl(database)
}
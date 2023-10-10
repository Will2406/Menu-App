package com.android.menu.data.di

import android.content.Context
import android.content.SharedPreferences
import com.android.menu.data.datasource.category.CategoryRemoteDataSource
import com.android.menu.data.datasource.category.CategoryRemoteDataSourceImpl
import com.android.menu.data.datasource.food.FoodLocalDataSource
import com.android.menu.data.datasource.food.FoodLocalDataSourceImpl
import com.android.menu.data.datasource.food.FoodRemoteDataSource
import com.android.menu.data.datasource.food.FoodRemoteDataSourceImpl
import com.android.menu.data.datasource.user.UserLocalDataSource
import com.android.menu.data.datasource.user.UserLocalDataSourceImp
import com.android.menu.data.datasource.user.UserRemoteDataSource
import com.android.menu.data.datasource.user.UserRemoteDataSourceImpl
import com.android.menu.data.local.database.MenuDatabase
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
    fun createUserLocalDataSource(sharedPreferences: SharedPreferences): UserLocalDataSource =
        UserLocalDataSourceImp(sharedPreferences)

    @Provides
    fun createFoodLocalDataSource(database: MenuDatabase): FoodLocalDataSource =
        FoodLocalDataSourceImpl(database)
}
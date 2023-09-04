package com.yape.data.di

import android.content.Context
import androidx.room.Room
import com.yape.data.local.MenuDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun createDataBaseInstance(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        MenuDatabase::class.java,
        "menu-data-base"
    ).build()
}
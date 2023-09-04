package com.android.menu.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.menu.data.local.FoodDao
import com.android.menu.data.local.FoodEntity

@Database(entities = [FoodEntity::class], version = 1)
abstract class MenuDatabase : RoomDatabase() {
    abstract fun foodDao(): FoodDao
}
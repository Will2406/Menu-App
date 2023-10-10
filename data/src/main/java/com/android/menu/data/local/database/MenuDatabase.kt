package com.android.menu.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FoodEntity::class], version = 1)
abstract class MenuDatabase : RoomDatabase() {
    abstract fun foodDao(): FoodDao
}
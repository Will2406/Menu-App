package com.android.menu.data.local.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface FoodDao {

    @Query("SELECT * FROM FoodEntity")
    fun getAll(): List<FoodEntity>

    @Query("SELECT * FROM FoodEntity where uid=:id")
    fun getFood(id: String): FoodEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(food: FoodEntity)

    @Delete
    fun delete(food: FoodEntity)
}
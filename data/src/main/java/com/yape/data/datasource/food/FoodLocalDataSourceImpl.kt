package com.yape.data.datasource.food

import com.yape.data.local.FoodEntity
import com.yape.data.local.MenuDatabase
import javax.inject.Inject

class FoodLocalDataSourceImpl @Inject constructor(
    private val database: MenuDatabase
) : FoodLocalDataSource {

    override suspend fun getAll(): List<FoodEntity> {
        return database.foodDao().getAll()
    }

    override suspend fun save(food: FoodEntity) {
        return database.foodDao().insert(food)
    }

    override suspend fun get(id: String): FoodEntity? {
        return database.foodDao().getFood(id)
    }

    override suspend fun delete(food: FoodEntity) {
        database.foodDao().delete(food)
    }
}
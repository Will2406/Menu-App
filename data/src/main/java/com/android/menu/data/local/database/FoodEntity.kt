package com.android.menu.data.local.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FoodEntity(
    @PrimaryKey val uid: String,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "rating") var rating: String,
    @ColumnInfo(name = "reviewers") var reviewers: String,
    @ColumnInfo(name = "calories") var calories: String,
    @ColumnInfo(name = "image") var image: String,
    @ColumnInfo(name = "is_saved") var isSaved: Boolean,
    @ColumnInfo(name = "price") var price: String,
    @ColumnInfo(name = "description") var description: String,
)
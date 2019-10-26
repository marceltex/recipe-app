package com.marceltex.recipeapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "images")
data class Image(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "recipe_id")
    var recipeId: Long,
    val path: String
)

package com.marceltex.recipeapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "images")
data class RecipeImage(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "recipe_id")
    var recipeId: Long,
    val path: String
)

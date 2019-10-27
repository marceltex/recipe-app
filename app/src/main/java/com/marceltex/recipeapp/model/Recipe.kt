package com.marceltex.recipeapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val description: String
)

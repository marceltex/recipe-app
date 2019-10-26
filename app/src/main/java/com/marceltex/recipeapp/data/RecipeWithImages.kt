package com.marceltex.recipeapp.data

import androidx.room.Embedded
import androidx.room.Relation

data class RecipeWithImages(
    @Embedded
    val recipe: Recipe,

    @Relation(parentColumn = "id", entityColumn = "recipeId")
    val images: List<Image>?
)

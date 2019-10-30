package com.marceltex.recipeapp.model

import androidx.room.Embedded
import androidx.room.Relation

data class RecipeWithImages(
    @Embedded
    val recipe: Recipe,

    @Relation(parentColumn = "id", entityColumn = "recipe_id")
    val recipeImages: List<RecipeImage>?
)

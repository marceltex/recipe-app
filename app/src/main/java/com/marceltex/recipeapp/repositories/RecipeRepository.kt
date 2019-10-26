package com.marceltex.recipeapp.repositories

import com.marceltex.recipeapp.data.RecipeWithImages

interface RecipeRepository {

    suspend fun getAllRecipes(): List<RecipeWithImages>

    suspend fun addRecipeWithImages(recipeWithImages: RecipeWithImages)
}

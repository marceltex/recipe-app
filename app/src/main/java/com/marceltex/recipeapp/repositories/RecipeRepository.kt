package com.marceltex.recipeapp.repositories

import com.marceltex.recipeapp.data.RecipeWithImages
import io.reactivex.Completable
import io.reactivex.Maybe

interface RecipeRepository {

    fun getAllRecipes(): Maybe<List<RecipeWithImages>>

    fun addRecipeWithImages(recipeWithImages: RecipeWithImages): Completable
}

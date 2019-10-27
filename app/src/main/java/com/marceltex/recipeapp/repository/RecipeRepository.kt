package com.marceltex.recipeapp.repository

import com.marceltex.recipeapp.model.RecipeWithImages
import io.reactivex.Completable
import io.reactivex.Maybe

interface RecipeRepository {

    fun getAllRecipes(): Maybe<List<RecipeWithImages>>

    fun addRecipeWithImages(recipeWithImages: RecipeWithImages): Completable
}

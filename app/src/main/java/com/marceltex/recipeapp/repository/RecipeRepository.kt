package com.marceltex.recipeapp.repository

import com.marceltex.recipeapp.model.Recipe
import io.reactivex.Completable
import io.reactivex.Observable

interface RecipeRepository {

    fun getAllRecipes(): Observable<List<Recipe>>

//    fun addRecipeWithImages(recipeWithImages: RecipeWithImages): Completable

    fun addRecipe(recipe: Recipe): Completable
}

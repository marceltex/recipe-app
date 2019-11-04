package com.marceltex.recipeapp.repository

import com.marceltex.recipeapp.database.RecipeDao
import com.marceltex.recipeapp.model.Recipe
import io.reactivex.Observable
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(private val dao: RecipeDao) : RecipeRepository {

    override fun getAllRecipes() = Observable.fromCallable<List<Recipe>> {
        dao.getAll()
    }

    override  fun addRecipe(recipe: Recipe) = dao.insertRecipe(recipe)
}

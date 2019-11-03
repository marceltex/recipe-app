package com.marceltex.recipeapp.repository

import com.marceltex.recipeapp.database.RecipeDao
import com.marceltex.recipeapp.model.Recipe
import io.reactivex.Observable
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(private val dao: RecipeDao) : RecipeRepository {

    override fun getAllRecipes() = Observable.fromCallable<List<Recipe>> {
//        Thread.sleep(2000)
        dao.getAll()
    }

    override  fun addRecipe(recipe: Recipe) = dao.insertRecipe(recipe)

//    override fun addRecipeWithImages(recipeWithImages: RecipeWithImages): Completable {
//        val recipeId = dao.insertRecipe(recipeWithImages.recipe).subscribeOn(Schedulers.io())
//
//        return if (!recipeWithImages.recipeImages.isNullOrEmpty()) {
//            recipeWithImages.recipeImages.map { image -> image.recipeId = recipeId.blockingGet() }
//            dao.insertImages(recipeWithImages.recipeImages)
//        } else {
//            Completable.complete()
//        }
//    }
}

package com.marceltex.recipeapp.repository

import com.marceltex.recipeapp.db.RecipeDao
import com.marceltex.recipeapp.model.RecipeWithImages
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(private val dao: RecipeDao) : RecipeRepository {

    override fun getAllRecipes() = Observable.fromCallable<List<RecipeWithImages>> {
        Thread.sleep(2000)
        dao.getAll()
    }

    override fun addRecipeWithImages(recipeWithImages: RecipeWithImages): Completable {
        val recipeId = dao.insertRecipe(recipeWithImages.recipe).subscribeOn(Schedulers.io())

        return if (!recipeWithImages.recipeImages.isNullOrEmpty()) {
            recipeWithImages.recipeImages.map { image -> image.recipeId = recipeId.blockingGet() }
            dao.insertImages(recipeWithImages.recipeImages)
        } else {
            Completable.complete()
        }
    }
}

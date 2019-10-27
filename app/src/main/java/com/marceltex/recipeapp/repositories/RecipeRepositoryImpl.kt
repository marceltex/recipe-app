package com.marceltex.recipeapp.repositories

import com.marceltex.recipeapp.data.RecipeWithImages
import com.marceltex.recipeapp.db.RecipeDao
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(private val dao: RecipeDao) : RecipeRepository {

    override fun getAllRecipes() = dao.getAll()

    override fun addRecipeWithImages(recipeWithImages: RecipeWithImages): Completable {
        val recipeId = dao.insertRecipe(recipeWithImages.recipe).subscribeOn(Schedulers.io())

        return if (!recipeWithImages.images.isNullOrEmpty()) {
            recipeWithImages.images.map { image -> image.recipeId = recipeId.blockingGet() }
            dao.insertImages(recipeWithImages.images)
        } else {
            Completable.complete()
        }
    }
}

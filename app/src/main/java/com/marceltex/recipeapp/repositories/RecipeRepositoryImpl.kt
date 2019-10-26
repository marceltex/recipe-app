package com.marceltex.recipeapp.repositories

import com.marceltex.recipeapp.data.RecipeWithImages
import com.marceltex.recipeapp.db.RecipeDao
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(private val dao: RecipeDao) : RecipeRepository {

    override suspend fun getAllRecipes() = dao.getAll()

    override suspend fun addRecipeWithImages(recipeWithImages: RecipeWithImages) {
        val recipeId = dao.insertRecipe(recipeWithImages.recipe)

        if (!recipeWithImages.images.isNullOrEmpty()) {
            recipeWithImages.images.forEach { image ->
                image.recipeId = recipeId
                dao.insertImage(image)
            }
        }
    }
}

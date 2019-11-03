package com.marceltex.recipeapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.marceltex.recipeapp.model.Recipe
import com.marceltex.recipeapp.model.RecipeWithImages
import io.reactivex.Completable

@Dao
interface RecipeDao {

    @Transaction
    @Query("SELECT * from recipes")
    fun getAll(): List<RecipeWithImages>

    @Insert
    fun insertRecipe(recipe: Recipe): Completable

//    @Insert
//    fun insertImages(recipeImages: List<RecipeImage>): Completable
}

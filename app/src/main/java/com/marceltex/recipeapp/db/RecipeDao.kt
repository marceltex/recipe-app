package com.marceltex.recipeapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.marceltex.recipeapp.data.Image
import com.marceltex.recipeapp.data.Recipe
import com.marceltex.recipeapp.data.RecipeWithImages

@Dao
interface RecipeDao {

    @Transaction
    @Query("SELECT * from recipes")
    suspend fun getAll(): List<RecipeWithImages>

    @Insert
    suspend fun insertRecipe(recipe: Recipe): Long

    @Insert
    suspend fun insertImage(image: Image): Long
}

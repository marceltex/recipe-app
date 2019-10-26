package com.marceltex.recipeapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.marceltex.recipeapp.data.Image
import com.marceltex.recipeapp.data.Recipe
import com.marceltex.recipeapp.data.RecipeWithImages

@Dao
interface RecipeDao {

    @Query("SELECT * from recipes")
    fun getAll(): List<RecipeWithImages>

    @Insert()
    fun addRecipe(recipe: Recipe): Long

    @Insert()
    fun addImage(image: Image): Long
}

package com.marceltex.recipeapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.marceltex.recipeapp.model.Recipe
import io.reactivex.Completable

@Dao
interface RecipeDao {

    @Transaction
    @Query("SELECT * from recipes")
    fun getAll(): List<Recipe>

    @Insert
    fun insertRecipe(recipe: Recipe): Completable
}

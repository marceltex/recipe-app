package com.marceltex.recipeapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.marceltex.recipeapp.model.Recipe
import com.marceltex.recipeapp.model.RecipeImage

@Database(entities = [Recipe::class, RecipeImage::class], version = 1)
abstract class RecipeDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao
}

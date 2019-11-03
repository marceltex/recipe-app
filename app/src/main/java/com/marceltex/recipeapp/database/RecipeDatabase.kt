package com.marceltex.recipeapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.marceltex.recipeapp.model.Recipe

@Database(entities = [Recipe::class], version = 2)
abstract class RecipeDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao
}

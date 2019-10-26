package com.marceltex.recipeapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.marceltex.recipeapp.data.Image
import com.marceltex.recipeapp.data.Recipe

@Database(entities = [Recipe::class, Image::class], version = 1)
abstract class RecipeDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao
}

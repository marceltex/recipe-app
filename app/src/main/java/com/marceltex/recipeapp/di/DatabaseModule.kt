package com.marceltex.recipeapp.di

import android.app.Application
import androidx.room.Room
import com.marceltex.recipeapp.db.RecipeDao
import com.marceltex.recipeapp.db.RecipeDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    internal fun provideDatabase(application: Application): RecipeDatabase =
        Room.databaseBuilder(application, RecipeDatabase::class.java, "CookingRecipes.db")
            .allowMainThreadQueries()
            .build()

    @Provides
    @Singleton
    internal fun provideRecipeDao(recipeDatabase: RecipeDatabase): RecipeDao =
        recipeDatabase.recipeDao()
}

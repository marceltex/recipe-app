package com.marceltex.recipeapp.di

import android.content.Context
import androidx.room.Room
import com.marceltex.recipeapp.database.RecipeDao
import com.marceltex.recipeapp.database.RecipeDatabase
import com.marceltex.recipeapp.repository.RecipeRepository
import com.marceltex.recipeapp.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): RecipeDatabase =
        Room.databaseBuilder(context, RecipeDatabase::class.java, "CookingRecipes.db")
            .allowMainThreadQueries()
            .build()

    @Provides
    @Singleton
    fun provideRecipeDao(recipeDatabase: RecipeDatabase): RecipeDao =
        recipeDatabase.recipeDao()

    @Provides
    @Singleton
    fun provideRecipeRepository(dao: RecipeDao): RecipeRepository =
        RecipeRepositoryImpl(dao)
}

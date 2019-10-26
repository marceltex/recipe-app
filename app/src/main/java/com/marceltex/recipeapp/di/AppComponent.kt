package com.marceltex.recipeapp.di

import com.marceltex.recipeapp.views.AddRecipeFragment
import com.marceltex.recipeapp.views.AllRecipesFragment
import com.marceltex.recipeapp.views.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(allRecipesFragment: AllRecipesFragment)

    fun inject(addRecipeFragment: AddRecipeFragment)
}

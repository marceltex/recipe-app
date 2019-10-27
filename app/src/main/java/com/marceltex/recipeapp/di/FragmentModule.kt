package com.marceltex.recipeapp.di

import com.marceltex.recipeapp.views.AddRecipeFragment
import com.marceltex.recipeapp.views.AllRecipesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeAllRecipesFragment(): AllRecipesFragment

    @ContributesAndroidInjector
    abstract fun contributeAddRecipeFragment(): AddRecipeFragment
}

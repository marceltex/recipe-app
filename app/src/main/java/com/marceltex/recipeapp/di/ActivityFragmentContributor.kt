package com.marceltex.recipeapp.di

import com.marceltex.recipeapp.ui.MainActivity
import com.marceltex.recipeapp.ui.addrecipe.AddRecipeFragment
import com.marceltex.recipeapp.ui.recipes.RecipesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityFragmentContributor {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeRecipesFragment(): RecipesFragment

    @ContributesAndroidInjector
    abstract fun contributeAddRecipeFragment(): AddRecipeFragment
}

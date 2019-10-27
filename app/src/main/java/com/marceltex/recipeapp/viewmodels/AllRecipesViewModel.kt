package com.marceltex.recipeapp.viewmodels

import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.marceltex.recipeapp.App
import com.marceltex.recipeapp.R
import com.marceltex.recipeapp.repositories.RecipeRepository
import com.marceltex.recipeapp.states.RecipeState

class AllRecipesViewModel(state: RecipeState, repository: RecipeRepository) : MvRxViewModel<RecipeState>(state) {

    companion object : MvRxViewModelFactory<AllRecipesViewModel, RecipeState> {

        override fun create(viewModelContext: ViewModelContext, state: RecipeState): AllRecipesViewModel? {
            val repository: RecipeRepository by viewModelContext.activity.inj

        }
    }
    // Todo: Get recipes from Room DB
//    fun getRecipes()
}

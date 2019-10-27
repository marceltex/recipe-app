package com.marceltex.recipeapp.ui.recipes

import com.airbnb.mvrx.*
import com.marceltex.recipeapp.MvRxViewModel
import com.marceltex.recipeapp.model.Recipe
import com.marceltex.recipeapp.repository.RecipeRepository
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

data class RecipeState(val recipes: Async<List<Recipe>> = Uninitialized) : MvRxState

class RecipesViewModel @AssistedInject constructor(
    @Assisted state: RecipeState,
    private val repository: RecipeRepository
) : MvRxViewModel<RecipeState>(state) {

    // Async call to fetch all recipes from DB
    fun fetchRecipes() {

    }

    @AssistedInject.Factory
    interface Factory {
        fun create(state: RecipeState): RecipesViewModel
    }

    companion object : MvRxViewModelFactory<RecipesViewModel, RecipeState> {

        override fun create(viewModelContext: ViewModelContext, state: RecipeState): RecipesViewModel? {
            val fragment = (viewModelContext as FragmentViewModelContext).fragment<RecipesFragment>()
            return fragment.viewModelFactory.create(state)
        }
    }
}

package com.marceltex.recipeapp.ui.recipes

import com.airbnb.mvrx.*
import com.marceltex.recipeapp.MvRxViewModel
import com.marceltex.recipeapp.model.RecipeWithImages
import com.marceltex.recipeapp.repository.RecipeRepository
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import io.reactivex.schedulers.Schedulers

data class RecipeState(val recipes: Async<List<RecipeWithImages>> = Uninitialized) : MvRxState

class RecipesViewModel @AssistedInject constructor(
    @Assisted state: RecipeState,
    private val repository: RecipeRepository
) : MvRxViewModel<RecipeState>(state) {

    // Async call to fetch all recipes from DB
    fun fetchRecipes() {

    }

    init {
        repository.getAllRecipes()
            .subscribeOn(Schedulers.io())
            .execute { copy(recipes = it) }
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

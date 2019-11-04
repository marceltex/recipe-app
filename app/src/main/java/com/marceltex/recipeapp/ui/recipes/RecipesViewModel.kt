package com.marceltex.recipeapp.ui.recipes

import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.marceltex.recipeapp.MvRxViewModel
import com.marceltex.recipeapp.repository.RecipeRepository
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import io.reactivex.schedulers.Schedulers

class RecipesViewModel @AssistedInject constructor(
    @Assisted state: RecipesState,
    private val repository: RecipeRepository
) : MvRxViewModel<RecipesState>(state) {

    init {
        refreshRecipes()
    }

    fun refreshRecipes() {
        repository.getAllRecipes()
            .subscribeOn(Schedulers.io())
            .execute { copy(recipes = it) }
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(state: RecipesState): RecipesViewModel
    }

    companion object : MvRxViewModelFactory<RecipesViewModel, RecipesState> {

        override fun create(viewModelContext: ViewModelContext, state: RecipesState): RecipesViewModel? {
            val fragment = (viewModelContext as FragmentViewModelContext).fragment<RecipesFragment>()
            return fragment.viewModelFactory.create(state)
        }
    }
}

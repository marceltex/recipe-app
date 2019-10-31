package com.marceltex.recipeapp.ui.addrecipe

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.marceltex.recipeapp.MvRxViewModel
import com.marceltex.recipeapp.model.RecipeWithImages
import com.marceltex.recipeapp.repository.RecipeRepository
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class AddRecipeViewModel @AssistedInject constructor(
    @Assisted state: AddRecipeState,
    repository: RecipeRepository
) : MvRxViewModel<AddRecipeState>(state) {

    init {
        setState { copy(recipe = Async<RecipeWithImages>()) }
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(state: AddRecipeState): AddRecipeViewModel
    }

    companion object : MvRxViewModelFactory<AddRecipeViewModel, AddRecipeState> {

        override fun create(viewModelContext: ViewModelContext, state: AddRecipeState): AddRecipeViewModel? {
            val fragment = (viewModelContext as FragmentViewModelContext).fragment<AddRecipeFragment>()
            return fragment.viewModelFactory.create(state)
        }
    }
}

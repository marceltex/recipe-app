package com.marceltex.recipeapp.ui.addrecipe

import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.marceltex.recipeapp.MvRxViewModel
import com.marceltex.recipeapp.model.Recipe
import com.marceltex.recipeapp.repository.RecipeRepository
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class AddRecipeViewModel @AssistedInject constructor(
    @Assisted state: AddRecipeState,
    private val repository: RecipeRepository
) : MvRxViewModel<AddRecipeState>(state) {

    fun setTitle(title: String) {
        setState { copy(newTitle = title) }
    }

    fun setDescription(description: String) {
        setState { copy(newDescription = description) }
    }

    fun setImages(images: String) {
        setState { copy(newImages = images) }
    }

    fun saveRecipe() {
        withState { state ->
            if (state.newTitle != null && state.newDescription != null) {
                val recipe = Recipe(title = state.newTitle, description = state.newDescription, images = state.newImages)
                repository.addRecipe(recipe)
                resetState()
            }
        }
    }

    private fun resetState() {
        setState { copy(newTitle = null, newDescription = null, newImages = null) }
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

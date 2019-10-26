package com.marceltex.recipeapp.viewmodels

import com.marceltex.recipeapp.states.RecipeState

class AddRecipeViewModel(state: RecipeState) : MvRxViewModel<RecipeState>(state) {

//    fun addRecipe(title: String, description: String, images: List<String>) = setState { copy(title = title, description = description, images = images) }
}

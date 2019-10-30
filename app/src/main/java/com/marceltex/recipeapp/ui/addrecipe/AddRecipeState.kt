package com.marceltex.recipeapp.ui.addrecipe

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.marceltex.recipeapp.model.RecipeWithImages

data class AddRecipeState(val recipe: Async<RecipeWithImages> = Uninitialized) : MvRxState

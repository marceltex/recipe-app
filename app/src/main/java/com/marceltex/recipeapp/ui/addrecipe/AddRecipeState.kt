package com.marceltex.recipeapp.ui.addrecipe

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.marceltex.recipeapp.model.Recipe

data class AddRecipeState(val recipe: Async<Recipe> = Uninitialized) : MvRxState

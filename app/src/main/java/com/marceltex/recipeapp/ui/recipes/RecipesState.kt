package com.marceltex.recipeapp.ui.recipes

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.marceltex.recipeapp.model.RecipeWithImages

data class RecipesState(val recipes: Async<List<RecipeWithImages>> = Uninitialized) : MvRxState

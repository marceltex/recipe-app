package com.marceltex.recipeapp.states

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.marceltex.recipeapp.data.Recipe

data class RecipeState(
    val recipes: Async<List<Recipe>> = Uninitialized
) : MvRxState

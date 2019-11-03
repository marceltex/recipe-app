package com.marceltex.recipeapp.ui.addrecipe

import com.airbnb.mvrx.MvRxState

data class AddRecipeState(val newTitle: String? = null, val newDescription: String? = null, val newImages: String? = null) : MvRxState

package com.marceltex.recipeapp.data

data class Recipe(
    val id: Int,
    val title: String,
    val description: String,
    val images: List<String>?
)

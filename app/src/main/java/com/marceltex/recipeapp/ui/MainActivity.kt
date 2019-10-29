package com.marceltex.recipeapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marceltex.recipeapp.R
import com.marceltex.recipeapp.ui.recipes.RecipesViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: RecipesViewModel.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

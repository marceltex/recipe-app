package com.marceltex.recipeapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.marceltex.recipeapp.R
import com.marceltex.recipeapp.viewmodel.AddRecipeViewModel

class AddRecipeFragment : BaseFragment() {

    override val title by lazy { getString(R.string.add_recipe_title) }

    private lateinit var viewModel: AddRecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_recipe_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddRecipeViewModel::class.java)
        // TODO: Use the ViewModel
    }
}

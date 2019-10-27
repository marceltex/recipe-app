package com.marceltex.recipeapp.ui.addrecipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marceltex.recipeapp.R
import com.marceltex.recipeapp.ui.BaseFragment

class AddRecipeFragment : BaseFragment() {

    override val title by lazy { getString(R.string.add_recipe_title) }
//
//    private val viewModel: AddRecipeViewModel by lazy { ViewModelProviders.of(this).get(
//        AddRecipeViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_recipe_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun invalidate() {

    }
}

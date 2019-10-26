package com.marceltex.recipeapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.marceltex.recipeapp.R
import com.marceltex.recipeapp.viewmodel.AllRecipesViewModel

class AllRecipesFragment : BaseFragment() {

    override val title by lazy { getString(R.string.all_recipes_title) }

    private lateinit var viewModel: AllRecipesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.all_recipes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AllRecipesViewModel::class.java)
        // TODO: Use the ViewModel
    }
}

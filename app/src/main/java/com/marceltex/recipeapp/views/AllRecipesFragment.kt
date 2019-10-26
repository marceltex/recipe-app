package com.marceltex.recipeapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.fragmentViewModel
import com.marceltex.recipeapp.R
import com.marceltex.recipeapp.viewmodels.AllRecipesViewModel

class AllRecipesFragment : BaseFragment() {

    override val title by lazy { getString(R.string.all_recipes_title) }

    private val viewModel: AllRecipesViewModel by fragmentViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.all_recipes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun invalidate() {

    }
}

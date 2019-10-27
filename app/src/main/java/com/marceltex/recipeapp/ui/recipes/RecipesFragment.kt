package com.marceltex.recipeapp.ui.recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.fragmentViewModel
import com.marceltex.recipeapp.R
import com.marceltex.recipeapp.ui.BaseFragment
import javax.inject.Inject

class RecipesFragment : BaseFragment() {

    override val title by lazy { getString(R.string.recipes_title) }

    @Inject
    lateinit var viewModelFactory: RecipesViewModel.Factory

    private val viewModel: RecipesViewModel by fragmentViewModel()

//    override fun onAttach(context: Context) {
//        AndroidSupportInjection.inject(this)
//        super.onAttach(context)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recipes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun invalidate() {

    }
}

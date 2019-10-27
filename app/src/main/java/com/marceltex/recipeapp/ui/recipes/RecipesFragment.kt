package com.marceltex.recipeapp.ui.recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.marceltex.recipeapp.R
import com.marceltex.recipeapp.ui.BaseFragment
import kotlinx.android.synthetic.main.recipes_fragment.*
import javax.inject.Inject

class RecipesFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: RecipesViewModel.Factory

    private val viewModel: RecipesViewModel by fragmentViewModel()

    private val recipesToolbar by lazy { toolbar as? Toolbar }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recipes_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipesToolbar?.setupWithNavController(findNavController())
        recipesToolbar?.inflateMenu(R.menu.recipes_menu)

        recipesToolbar?.setOnMenuItemClickListener { item ->
            when(item.itemId) {
                R.id.action_add -> findNavController().navigate(R.id.action_recipesFragment_to_addRecipeFragment)
            }

            false
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun invalidate() = withState(viewModel) { state ->

    }
}

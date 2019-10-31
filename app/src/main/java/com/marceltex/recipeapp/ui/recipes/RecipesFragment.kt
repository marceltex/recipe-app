package com.marceltex.recipeapp.ui.recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.marceltex.recipeapp.R
import com.marceltex.recipeapp.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_recipes.*
import javax.inject.Inject

class RecipesFragment : BaseFragment() {

    private val viewModel: RecipesViewModel by fragmentViewModel()

    @Inject
    lateinit var viewModelFactory: RecipesViewModel.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun invalidate() = withState(viewModel) { state ->
        loadingProgressBar.isVisible = state.recipes is Loading
        recipesRecyclerView.withModels {
            state.recipes()?.forEach { recipeWithImages ->
                recipeRow {
                    id(recipeWithImages.recipe.id.toInt())
                    recipe(recipeWithImages.recipe)
                }
            }
        }
//        bindings.state = state
    }
}

package com.marceltex.recipeapp.ui.recipes

import android.os.Bundle
import android.view.*
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.marceltex.recipeapp.R
import com.marceltex.recipeapp.epoxymodel.recipeRow
import com.marceltex.recipeapp.ui.BaseFragment
import kotlinx.android.synthetic.main.recipes_fragment.*
import java.io.File
import javax.inject.Inject

class RecipesFragment : BaseFragment() {

    private val viewModel: RecipesViewModel by fragmentViewModel()

    @Inject
    lateinit var viewModelFactory: RecipesViewModel.Factory
    @Inject
    lateinit var gson: Gson

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.recipes_fragment, container, false)
        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.recipes_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_add -> findNavController().navigate(R.id.action_recipesFragment_to_addRecipeFragment)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.refreshRecipes()
    }

    override fun invalidate() = withState(viewModel) { state ->
        val type = object : TypeToken<Array<File>>() {}.type

        loadingProgressBar.isVisible = state.recipes is Loading
        if (state.recipes().isNullOrEmpty()) {
            recipesRecyclerView.visibility = View.GONE
            noRecipesTextView.visibility = View.VISIBLE

        } else {
            recipesRecyclerView.visibility = View.VISIBLE
            noRecipesTextView.visibility = View.GONE

            recipesRecyclerView.withModels {
                state.recipes()?.forEach { recipe ->
                    recipeRow {
                        id(recipe.id!!.toInt())
                        title(recipe.title)
                        description(recipe.description)
                        images(gson.fromJson<Array<File>>(recipe.images, type))
                    }
                }
            }
        }
    }
}

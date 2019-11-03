package com.marceltex.recipeapp.ui.addrecipe

import android.os.Bundle
import android.view.*
import android.widget.Toast
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.marceltex.recipeapp.R
import com.marceltex.recipeapp.ui.BaseFragment
import kotlinx.android.synthetic.main.add_recipe_fragment.*
import javax.inject.Inject

class AddRecipeFragment : BaseFragment() {

    private val viewModel: AddRecipeViewModel by fragmentViewModel()

    @Inject
    lateinit var viewModelFactory: AddRecipeViewModel.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_recipe_fragment, container, false)
        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_recipe_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_save && areAllFieldsValid()) {
            viewModel.saveRecipe()
            Toast.makeText(context, R.string.recipe_saved_successfully_toast, Toast.LENGTH_SHORT)
                .show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun areAllFieldsValid(): Boolean {
        var allValid = true

        if (titleEditText.text.isNotBlank()) {
            titleTextInputLayout.error = ""
        } else {
            titleTextInputLayout.error = getString(R.string.title_error)
            allValid = false
        }

        if (descriptionEditText.text.isNotBlank()) {
            descriptionTextInputLayout.error = ""
        } else {
            descriptionTextInputLayout.error = getString(R.string.description_error)
            allValid = false
        }

        return allValid
    }

    override fun invalidate() = withState(viewModel) { state ->
        //        val recipeWithImages = state.recipe()
//
//        titleEditText.setText(recipeWithImages?.recipe?.title)
//        descriptionEditText.setText(recipeWithImages?.recipe?.description)
    }
}

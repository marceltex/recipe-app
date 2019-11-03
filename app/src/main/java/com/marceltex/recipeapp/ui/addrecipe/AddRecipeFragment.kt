package com.marceltex.recipeapp.ui.addrecipe

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
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_recipe_view.*
import javax.inject.Inject

class AddRecipeFragment : BaseFragment() {

    private val viewModel: AddRecipeViewModel by fragmentViewModel()

    @Inject
    lateinit var viewModelFactory: AddRecipeViewModel.Factory

    private val addRecipeToolbar by lazy { toolbar as? Toolbar }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addRecipeToolbar?.setupWithNavController(findNavController())
        addRecipeToolbar?.inflateMenu(R.menu.add_recipe_menu)

        addRecipeToolbar?.setOnMenuItemClickListener { item ->
            if (item.itemId == R.id.action_save && allFieldsValid()) {
                findNavController().popBackStack()
            }
            false
        }
    }

    private fun allFieldsValid(): Boolean {
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
        val recipeWithImages = state.recipe()

        titleEditText.setText(recipeWithImages?.recipe?.title)
        descriptionEditText.setText(recipeWithImages?.recipe?.description)
    }
}

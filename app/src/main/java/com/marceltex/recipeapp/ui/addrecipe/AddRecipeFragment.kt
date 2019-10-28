package com.marceltex.recipeapp.ui.addrecipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.marceltex.recipeapp.R
import com.marceltex.recipeapp.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_add_recipe.*

class AddRecipeFragment : BaseFragment() {
//
//    private val viewModel: AddRecipeViewModel by lazy { ViewModelProviders.of(this).get(
//        AddRecipeViewModel::class.java) }

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
            when(item.itemId) {
                R.id.action_save -> findNavController().popBackStack()
            }

            false
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun invalidate() {

    }
}

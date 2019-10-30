package com.marceltex.recipeapp.ui.recipes

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.marceltex.recipeapp.R
import com.marceltex.recipeapp.model.Recipe
import kotlinx.android.synthetic.main.recipe_row.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class RecipeRow @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.recipe_row, this, true )
    }

    @ModelProp
    fun setRecipe(recipe: Recipe) {
        titleTextView.text = recipe.title
        descriptionTextView.text = recipe.description
    }

//    @TextProp
//    fun setTitle(title: CharSequence) {
//        titleTextView.text = title
//    }
//
//    @TextProp
//    fun setDescription(description: CharSequence) {
//        descriptionTextView.text = description
//    }
}

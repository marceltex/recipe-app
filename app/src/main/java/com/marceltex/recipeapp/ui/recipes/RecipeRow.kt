package com.marceltex.recipeapp.ui.recipes

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.TextProp
import kotlinx.android.synthetic.main.recipe_row.view.*

class RecipeRow @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    @TextProp
    fun setTitle(title: CharSequence) {
        titleTextView.text = title
    }

    @TextProp
    fun setDescription(description: CharSequence) {
        descriptionTextView.text = description
    }
}

package com.marceltex.recipeapp.ui.addrecipe

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.marceltex.recipeapp.R
import kotlinx.android.synthetic.main.recipe_row.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class AddRecipeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.add_recipe_view, this, true )
    }

    @TextProp
    fun setTitle(title: CharSequence) {
        titleTextView.text = title
    }

    @TextProp
    fun setDescription(description: CharSequence) {
        descriptionTextView.text = description
    }
}

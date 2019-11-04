package com.marceltex.recipeapp.epoxymodel

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.marceltex.recipeapp.R
import kotlinx.android.synthetic.main.recipe_row.view.*
import java.io.File

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class RecipeRow @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.recipe_row, this, true)
    }

    @TextProp
    fun setTitle(title: CharSequence) {
        titleTextView.text = title
    }

    @TextProp
    fun setDescription(description: CharSequence) {
        descriptionTextView.text = description
    }

    @ModelProp
    fun setImages(images: Array<File>?) {
        if (!images.isNullOrEmpty()) {
            imagesRecyclerView.visibility = View.VISIBLE
            imagesRecyclerView.withModels {
                images.forEach { image ->
                    imageColumn {
                        id(image.name)
                        image(image)
                    }
                }
            }
        }
    }
}

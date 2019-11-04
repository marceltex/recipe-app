package com.marceltex.recipeapp.epoxymodel

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.marceltex.recipeapp.R
import kotlinx.android.synthetic.main.image_column.view.*
import java.io.File

@ModelView(autoLayout = ModelView.Size.WRAP_WIDTH_MATCH_HEIGHT)
class ImageColumn @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.image_column, this, true)
    }

    @ModelProp
    fun setImage(file: File) {
        recipeImageView.setFile(file)
    }
}

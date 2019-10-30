package com.marceltex.recipeapp.ui.recipes

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.marceltex.recipeapp.R
import com.squareup.picasso.Picasso
import javax.inject.Inject

class RecipeImageView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr:Int = 0
) : AppCompatImageView(context, attr, defStyleAttr) {

    @Inject
    private lateinit var picasso: Picasso

    fun setPath(path: String?) {
        if (path == null) {
            picasso.cancelRequest(this)
            setImageDrawable(null)
            return
        }

        picasso.load(path)
            .placeholder(R.color.loading)
            .into(this)
    }
}

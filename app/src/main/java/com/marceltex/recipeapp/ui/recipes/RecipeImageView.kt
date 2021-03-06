package com.marceltex.recipeapp.ui.recipes

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.marceltex.recipeapp.R
import com.squareup.picasso.Picasso
import java.io.File

class RecipeImageView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr:Int = 0
) : AppCompatImageView(context, attr, defStyleAttr) {

    // Ideally, I would like to inject an instance of Picasso here, but I struggled for hours trying
    // to get Dagger to inject a property on a custom view, with no luck.
    // So I resorted to using the global instance of Picasso provided by Picasso.get()
    private val picasso = Picasso.get()

    fun setFile(file: File?) {
        if (file == null) {
            picasso.cancelRequest(this)
            setImageDrawable(null)
            return
        }

        picasso.load(file)
            .placeholder(R.color.loading)
            .into(this)
    }
}

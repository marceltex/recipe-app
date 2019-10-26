package com.marceltex.recipeapp.views

import androidx.appcompat.app.AppCompatActivity
import com.airbnb.mvrx.BaseMvRxFragment

abstract class BaseFragment : BaseMvRxFragment() {

    open val title: String = ""

    override fun onResume() {
        super.onResume()
        (activity as? AppCompatActivity)?.supportActionBar?.title = title
    }
}

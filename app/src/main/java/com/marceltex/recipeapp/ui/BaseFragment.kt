package com.marceltex.recipeapp.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.mvrx.BaseMvRxFragment

abstract class BaseFragment : BaseMvRxFragment() {

    open val title: String = ""

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onResume() {
        super.onResume()
        (activity as? AppCompatActivity)?.supportActionBar?.title = title
    }
}

package com.marceltex.recipeapp.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.mvrx.BaseMvRxFragment
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment : BaseMvRxFragment() {

    open val title = ""

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onResume() {
        super.onResume()
        (activity as? AppCompatActivity)?.supportActionBar?.title = title
    }
}

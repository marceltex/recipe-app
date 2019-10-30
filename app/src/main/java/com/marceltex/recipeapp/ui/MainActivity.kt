package com.marceltex.recipeapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marceltex.recipeapp.R
import dagger.android.AndroidInjection

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

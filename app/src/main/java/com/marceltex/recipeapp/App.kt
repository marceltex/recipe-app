package com.marceltex.recipeapp

import android.app.Application
import android.content.Context
import com.marceltex.recipeapp.di.AppComponent
import com.marceltex.recipeapp.di.DaggerAppComponent

class App : Application() {

    lateinit var component: AppComponent private set

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder().build()
    }

    companion object {
        fun get(context: Context) = context.applicationContext as App

        fun getComponent(context: Context) = get(context).component
    }
}

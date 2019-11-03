package com.marceltex.recipeapp.di

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import pl.aprilapps.easyphotopicker.EasyImage
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideEasyImage(context: Context): EasyImage =
        EasyImage.Builder(context)
            .allowMultiple(true)
            .build()
}

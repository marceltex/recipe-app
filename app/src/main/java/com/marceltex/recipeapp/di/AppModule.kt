package com.marceltex.recipeapp.di

import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun providesPicasso(): Picasso = Picasso.get()
}

package com.marceltex.recipeapp.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

//    @Singleton
//    @Provides
//    fun provideApplicationContext(app: MvRxApplication): Context = app

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

//    @Provides
//    @Singleton
//    fun provideEasyImage(context: Context): EasyImage =
//        EasyImage.Builder(context)
//            .allowMultiple(true)
//            .build()
}

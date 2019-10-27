package com.marceltex.recipeapp.di

import android.app.Application
import com.marceltex.recipeapp.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(modules = [ActivityModule::class, DatabaseModule::class, FragmentModule::class, AndroidSupportInjectionModule::class])


@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}

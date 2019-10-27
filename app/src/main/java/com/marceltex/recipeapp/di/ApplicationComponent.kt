package com.marceltex.recipeapp.di

import android.content.Context
import com.marceltex.recipeapp.MvRxApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityFragmentContributor::class, AndroidSupportInjectionModule::class, AppAssistedModule::class, DatabaseModule::class])
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(context: Context): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: MvRxApplication)

    override fun inject(instance: DaggerApplication?)
}

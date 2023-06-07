package com.example.friendstracker.di.app

import com.example.common.di.ApplicationScope
import com.example.data.di.DataModule
import com.example.friendstracker.App
import com.example.friendstracker.di.dependencies.DependenciesModule
import com.example.friendstracker.di.dependencies.FeatureDependencies
import com.example.friendstracker.glue.FeatureModule
import com.example.friendstracker.navigation.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component

@[ApplicationScope Component(
    modules = [
        AppModule::class,
        DependenciesModule::class,
        DataModule::class,
        FeatureModule::class,
    ]
)]
interface AppComponent : FeatureDependencies {

    fun inject(app: App)

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance
            application: App
        ): AppComponent
    }

    companion object {
        fun init(application: App) = DaggerAppComponent.factory()
            .create(application)
    }
}
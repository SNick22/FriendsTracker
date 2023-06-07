package com.example.friendstracker

import android.app.Application
import android.content.Context
import com.example.common.di.ComponentDependencies
import com.example.common.di.DependenciesContainer
import com.example.friendstracker.di.app.AppComponent
import com.example.friendstracker.di.dependencies.DependenciesManager
import com.yandex.mapkit.MapKitFactory
import javax.inject.Inject


class App: Application(), DependenciesContainer {

    @Inject
    lateinit var dependenciesManager: DependenciesManager

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        MapKitFactory.setApiKey(BuildConfig.API_YANDEX_MAPS)

        appComponent = AppComponent.init(this)
        appComponent.inject(this)
    }

    override fun <T : ComponentDependencies> getDependencies(key: Class<T>): T =
        dependenciesManager.getDependencies(key)
}

fun Context.getAppComponent() = (this.applicationContext as App).appComponent

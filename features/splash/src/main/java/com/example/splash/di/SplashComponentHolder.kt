package com.example.splash.di

import android.content.Context
import com.example.common.di.ComponentDependenciesProvider
import com.example.common.di.FeatureComponentHolder

object SplashComponentHolder: FeatureComponentHolder<SplashComponent>() {

    override fun build(context: Context): SplashComponent =
        DaggerSplashComponent.factory()
            .create(ComponentDependenciesProvider.get(context))
}
package com.example.main.di

import android.content.Context
import com.example.common.di.ComponentDependenciesProvider
import com.example.common.di.FeatureComponentHolder

object MainComponentHolder: FeatureComponentHolder<MainComponent>() {

    override fun build(context: Context): MainComponent =
        DaggerMainComponent.factory()
            .create(ComponentDependenciesProvider.get(context))
}
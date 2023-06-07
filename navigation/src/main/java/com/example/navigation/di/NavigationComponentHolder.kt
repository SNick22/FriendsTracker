package com.example.navigation.di

import com.example.common.di.ComponentDependenciesProvider
import com.example.friendstracker.navigation.presentation.MainActivity

object NavigationComponentHolder {

    private var component: NavigationComponent? = null

    fun get(activity: com.example.friendstracker.navigation.presentation.MainActivity) =
        component ?: run {
            build(activity).also(::set)
            component!!
        }

    private fun set(component: NavigationComponent) {
        this.component = component
    }

    private fun build(activity: com.example.friendstracker.navigation.presentation.MainActivity) =
        DaggerNavigationComponent.factory()
            .create(ComponentDependenciesProvider.get(activity), activity)
}
package com.example.navigation.di

import com.example.common.di.DiComponent
import com.example.friendstracker.navigation.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component

@[NavigationScope Component(
    dependencies = [NavigationDependencies::class],
    modules = [NavigationModule::class],
)]
interface  NavigationComponent : DiComponent {

    fun inject(activity: com.example.friendstracker.navigation.presentation.MainActivity)

    @Component.Factory
    interface Factory {

        fun create(
            deps: NavigationDependencies,
            @BindsInstance
            activity: com.example.friendstracker.navigation.presentation.MainActivity
        ): NavigationComponent
    }
}
package com.example.splash.di

import com.example.common.di.DiComponent
import com.example.splash.presentation.SplashFragment
import dagger.Component

@Component(
    dependencies = [SplashDependencies::class]
)
interface SplashComponent: DiComponent {

    fun inject(fragment: SplashFragment)

    @Component.Factory
    interface Factory {

        fun create(dependencies: SplashDependencies): SplashComponent
    }
}
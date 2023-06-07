package com.example.main.di

import com.example.common.di.DiComponent
import com.example.main.presentation.MainFragment
import com.example.main.presentation.MainViewModel
import dagger.Component

@Component(
    dependencies = [MainDependencies::class]
)
interface MainComponent: DiComponent {

    fun inject(fragment: MainFragment)

    fun mainViewModel(): MainViewModel

    @Component.Factory
    interface Factory {

        fun create(dependencies: MainDependencies): MainComponent
    }
}
package com.example.friendstracker.di.dependencies

import com.example.authorisation.di.AuthorisationDependencies
import com.example.common.di.ComponentDependencies
import com.example.friendstracker.di.app.AppComponent
import com.example.main.di.MainDependencies
import com.example.registration.di.RegistrationDependencies
import com.example.splash.di.SplashDependencies
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface DependenciesModule {

    @Binds @IntoMap
    @ComponentDependenciesKey(SplashDependencies::class)
    fun splashDependencies(ac: AppComponent): ComponentDependencies

    @Binds @IntoMap
    @ComponentDependenciesKey(AuthorisationDependencies::class)
    fun authorisationDependencies(ac: AppComponent): ComponentDependencies

    @Binds @IntoMap
    @ComponentDependenciesKey(RegistrationDependencies::class)
    fun registrationDependencies(ac: AppComponent): ComponentDependencies

    @Binds @IntoMap
    @ComponentDependenciesKey(MainDependencies::class)
    fun mainDependencies(ac: AppComponent): ComponentDependencies
}
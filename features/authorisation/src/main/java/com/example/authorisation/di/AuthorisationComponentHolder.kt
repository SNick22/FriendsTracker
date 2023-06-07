package com.example.authorisation.di

import android.content.Context
import com.example.common.di.ComponentDependenciesProvider
import com.example.common.di.FeatureComponentHolder

object AuthorisationComponentHolder: FeatureComponentHolder<AuthorisationComponent>() {

    override fun build(context: Context): AuthorisationComponent =
        DaggerAuthorisationComponent.factory()
            .create(ComponentDependenciesProvider.get(context))
}
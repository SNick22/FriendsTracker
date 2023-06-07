package com.example.registration.di

import android.content.Context
import com.example.common.di.ComponentDependenciesProvider
import com.example.common.di.FeatureComponentHolder

object RegistrationComponentHolder: FeatureComponentHolder<RegistrationComponent>() {

    override fun build(context: Context): RegistrationComponent =
        DaggerRegistrationComponent.factory()
            .create(ComponentDependenciesProvider.get(context))
}
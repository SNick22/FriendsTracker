package com.example.registration.di

import com.example.common.di.DiComponent
import com.example.registration.presentation.RegistrationFragment
import com.example.registration.presentation.RegistrationViewModel
import dagger.Component

@Component(
    dependencies = [RegistrationDependencies::class]
)
interface RegistrationComponent: DiComponent {

    fun inject(fragment: RegistrationFragment)

    fun registrationViewModel(): RegistrationViewModel

    @Component.Factory
    interface Factory {

        fun create(dependencies: RegistrationDependencies): RegistrationComponent
    }
}
package com.example.authorisation.di

import com.example.authorisation.presentation.enter_authorisation_code.EnterAuthorisationCodeFragment
import com.example.authorisation.presentation.enter_number.EnterNumberFragment
import com.example.common.di.DiComponent
import dagger.Component

@Component(
    dependencies = [AuthorisationDependencies::class]
)
interface AuthorisationComponent: DiComponent {

    fun inject(fragment: EnterNumberFragment)

    fun inject(fragment: EnterAuthorisationCodeFragment)

    @Component.Factory
    interface Factory {

        fun create(dependencies: AuthorisationDependencies): AuthorisationComponent
    }
}
package com.example.registration.di

import com.example.common.di.ComponentDependencies
import com.example.registration.RegistrationRouter
import com.example.registration.domain.repositories.AccountRepository

interface RegistrationDependencies: ComponentDependencies {

    fun registrationRouter(): RegistrationRouter

    fun registrationAccountRepository(): AccountRepository
}
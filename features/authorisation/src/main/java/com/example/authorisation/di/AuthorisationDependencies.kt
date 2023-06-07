package com.example.authorisation.di

import com.example.authorisation.EnterAuthorisationCodeRouter
import com.example.authorisation.EnterNumberRouter
import com.example.authorisation.domain.repositories.AccountRepository
import com.example.authorisation.presentation.enter_number.EnterNumberViewModel
import com.example.common.di.ComponentDependencies

interface AuthorisationDependencies: ComponentDependencies {

    fun enterNumberRouter(): EnterNumberRouter

    fun enterAuthorisationCodeRouter(): EnterAuthorisationCodeRouter

    fun authorisationAccountRepository(): AccountRepository

    fun enterNumberViewModel(): EnterNumberViewModel
}
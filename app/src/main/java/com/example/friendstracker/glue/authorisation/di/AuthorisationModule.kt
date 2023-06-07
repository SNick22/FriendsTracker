package com.example.friendstracker.glue.authorisation.di

import com.example.authorisation.EnterAuthorisationCodeRouter
import com.example.authorisation.EnterNumberRouter
import com.example.authorisation.domain.repositories.AccountRepository
import com.example.friendstracker.glue.authorisation.AdapterEnterAuthorisationCodeRouter
import com.example.friendstracker.glue.authorisation.AdapterEnterNumberRouter
import com.example.friendstracker.glue.authorisation.repositories.AdapterAccountRepository
import dagger.Binds
import dagger.Module

@Module
interface AuthorisationModule {

    @Binds
    fun bindEnterNumberRouter(adapterEnterNumberRouter: AdapterEnterNumberRouter): EnterNumberRouter

    @Binds
    fun bindEnterAuthorisationCodeRouter(
        adapterEnterAuthorisationCodeRouter: AdapterEnterAuthorisationCodeRouter
    ) : EnterAuthorisationCodeRouter

    @Binds
    fun bindAccountRepository(adapterAccountRepository: AdapterAccountRepository): AccountRepository
}
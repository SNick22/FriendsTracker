package com.example.friendstracker.glue.registration.di

import com.example.friendstracker.glue.registration.AdapterRegistrationRouter
import com.example.friendstracker.glue.registration.repositories.AdapterAccountRepository
import com.example.registration.RegistrationRouter
import com.example.registration.domain.repositories.AccountRepository
import dagger.Binds
import dagger.Module

@Module
interface RegistrationModule {

    @Binds
    fun bindRegistrationRouter(adapterRegistrationRouter: AdapterRegistrationRouter): RegistrationRouter

    @Binds
    fun bindAccountRepository(adapterAccountRepository: AdapterAccountRepository): AccountRepository
}
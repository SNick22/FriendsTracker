package com.example.data.account.di

import com.example.data.AccountDataRepository
import com.example.data.account.RealAccountDataRepository
import dagger.Binds
import dagger.Module

@Module
interface AccountDataRepositoryModule {

    @Binds
    fun bindAccountDataRepository(repository: RealAccountDataRepository): AccountDataRepository
}
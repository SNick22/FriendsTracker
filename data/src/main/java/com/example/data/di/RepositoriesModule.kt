package com.example.data.di

import com.example.data.account.di.AccountDataRepositoryModule
import com.example.data.location.di.LocationDataRepositoryModule
import dagger.Module

@Module(
    includes = [
        AccountDataRepositoryModule::class,
        LocationDataRepositoryModule::class,
    ]
)
interface RepositoriesModule

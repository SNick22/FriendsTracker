package com.example.friendstracker.glue.main.di

import com.example.friendstracker.glue.main.AdapterMainRouter
import com.example.friendstracker.glue.main.repositories.AdapterLocationRepository
import com.example.main.MainRouter
import com.example.main.domain.repositories.LocationRepository
import dagger.Binds
import dagger.Module

@Module
interface MainModule {

    @Binds
    fun bindMainRouter(router: AdapterMainRouter): MainRouter

    @Binds
    fun bindAccountRepository(repository: AdapterLocationRepository): LocationRepository
}
package com.example.data.location.di

import com.example.data.LocationDataRepository
import com.example.data.location.RealLocationDataRepository
import dagger.Binds
import dagger.Module

@Module
interface LocationDataRepositoryModule {

    @Binds
    fun bindLocationDataRepository(repository: RealLocationDataRepository): LocationDataRepository
}
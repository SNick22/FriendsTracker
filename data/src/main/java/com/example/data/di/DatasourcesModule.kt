package com.example.data.di

import com.example.data.datasources.remote.location.di.LocationModule
import com.example.data.datasources.remote.network.di.NetworkModule
import dagger.Module

@Module(
    includes = [
        LocationModule::class,
        NetworkModule::class
    ]
)
interface DatasourcesModule

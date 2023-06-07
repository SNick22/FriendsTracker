package com.example.data.di

import dagger.Module

@Module(
    includes = [DatasourcesModule::class, RepositoriesModule::class]
)
interface DataModule
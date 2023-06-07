package com.example.friendstracker.glue.splash.di

import com.example.friendstracker.glue.splash.AdapterSplashRouter
import com.example.friendstracker.glue.splash.repositories.AdapterAccountRepository
import com.example.splash.SplashRouter
import com.example.splash.domain.repositories.AccountRepository
import dagger.Binds
import dagger.Module

@Module
interface SplashModule {

    @Binds
    fun bindSplashRouter(adapterSplashRouter: AdapterSplashRouter): SplashRouter

    @Binds
    fun bindAccountRepository(adapterAccountRepository: AdapterAccountRepository): AccountRepository
}
package com.example.splash.di

import com.example.common.di.ComponentDependencies
import com.example.splash.SplashRouter
import com.example.splash.domain.repositories.AccountRepository
import com.example.splash.presentation.SplashViewModel

interface SplashDependencies: ComponentDependencies {

    fun splashRouter(): SplashRouter

    fun splashAccountRepository(): AccountRepository

    fun splashViewModel(): SplashViewModel
}
package com.example.friendstracker.glue

import com.example.friendstracker.glue.authorisation.di.AuthorisationModule
import com.example.friendstracker.glue.main.di.MainModule
import com.example.friendstracker.glue.registration.di.RegistrationModule
import com.example.friendstracker.glue.splash.di.SplashModule
import dagger.Module

@Module(
    includes = [
        SplashModule::class,
        AuthorisationModule::class,
        RegistrationModule::class,
        MainModule::class
    ]
)
interface FeatureModule

package com.example.friendstracker.di.dependencies

import com.example.authorisation.di.AuthorisationDependencies
import com.example.main.di.MainDependencies
import com.example.registration.di.RegistrationDependencies
import com.example.splash.di.SplashDependencies

interface FeatureDependencies:
        SplashDependencies,
        AuthorisationDependencies,
        RegistrationDependencies,
        MainDependencies

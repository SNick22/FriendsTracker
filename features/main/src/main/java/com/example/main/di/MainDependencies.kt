package com.example.main.di

import com.example.common.di.ComponentDependencies
import com.example.main.MainRouter
import com.example.main.domain.repositories.LocationRepository

interface MainDependencies: ComponentDependencies {

    fun mainLocationRepository(): LocationRepository

    fun mainRouter(): MainRouter
}
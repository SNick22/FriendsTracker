package com.example.common.di

import kotlin.reflect.KClass


interface DependenciesContainer {

    fun <T: ComponentDependencies> getDependencies(key: Class<T>): T
}
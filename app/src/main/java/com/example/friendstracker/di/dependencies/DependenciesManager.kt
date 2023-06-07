package com.example.friendstracker.di.dependencies

import com.example.common.di.ComponentDependencies
import java.lang.IllegalStateException
import javax.inject.Inject


typealias MapOfDeps = Map<Class<out ComponentDependencies>, @JvmSuppressWildcards ComponentDependencies>

class DependenciesManager @Inject constructor (
    private val dependencies: MapOfDeps
) {

    @Suppress("UNCHECKED_CAST")
    fun <T : ComponentDependencies> getDependencies(key: Class<T>): T =
        dependencies[key] as T? ?: throw IllegalStateException("Dependencies for $key is missing")
}
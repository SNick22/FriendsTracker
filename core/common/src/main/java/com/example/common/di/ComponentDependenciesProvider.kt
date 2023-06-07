package com.example.common.di

import android.content.Context

object ComponentDependenciesProvider {

    inline fun <reified T: ComponentDependencies> get(context: Context): T =
        (context.applicationContext as DependenciesContainer).getDependencies(T::class.java)
}
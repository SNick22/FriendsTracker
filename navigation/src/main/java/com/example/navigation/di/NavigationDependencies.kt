package com.example.navigation.di

import android.content.Context
import com.example.common.di.ComponentDependencies

interface NavigationDependencies: ComponentDependencies {

    fun context(): Context
}
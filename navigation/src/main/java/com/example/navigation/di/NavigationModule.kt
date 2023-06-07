package com.example.navigation.di

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.navigation.R
import com.example.friendstracker.navigation.presentation.MainActivity
import dagger.Module
import dagger.Provides

@Module
class NavigationModule {

    @Provides
    fun provideNavigationController(activity: com.example.friendstracker.navigation.presentation.MainActivity): NavController =
        (activity.supportFragmentManager.findFragmentById(R.id.fragment_container)
                as NavHostFragment).navController
}
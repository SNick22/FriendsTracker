package com.example.friendstracker.di.app

import android.content.Context
import com.example.friendstracker.App
import dagger.Binds
import dagger.Module

@Module
interface AppModule {

    @Binds
    fun provideContext(application: App): Context
}
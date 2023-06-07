package com.example.common.di

import android.content.Context

interface ComponentHolder<T : DiComponent> {

    fun get(context: Context): T

    fun set(component: T)
}
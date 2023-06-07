package com.example.common.di

import android.content.Context
import java.lang.ref.WeakReference

abstract class FeatureComponentHolder<T : DiComponent> : ComponentHolder<T> {

    private var component: WeakReference<T>? = null

    override fun get(context: Context): T =
        component?.get() ?: run {
            build(context).also(::set)
            component?.get()!!
        }

    override fun set(component: T) {
        this.component = WeakReference(component)
    }

    protected abstract fun build(context: Context): T
}
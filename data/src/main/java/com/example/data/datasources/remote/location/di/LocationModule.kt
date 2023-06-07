package com.example.data.datasources.remote.location.di

import android.content.Context
import android.location.Criteria
import android.location.LocationManager
import dagger.Module
import dagger.Provides

@Module
class LocationModule {

    @Provides
    fun provideLocationManager(context: Context): LocationManager =
        context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    @Provides
    @LocationProviderQualifier
    fun provideLocationProvider(locationManager: LocationManager): String? {
        val criteria = Criteria()
        criteria.accuracy = Criteria.ACCURACY_FINE
        return locationManager.getBestProvider(criteria, true)
    }
}
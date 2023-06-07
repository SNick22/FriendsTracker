package com.example.data.datasources.remote.location

import android.annotation.SuppressLint
import android.location.LocationManager
import com.example.data.datasources.remote.location.di.LocationProviderQualifier
import com.example.data.datasources.remote.location.entity.LocationDataEntity
import com.example.data.datasources.remote.location.mapper.toLocationDataEntity
import javax.inject.Inject

class LocationDataSource @Inject constructor(
    private val locationManager: LocationManager,
    @LocationProviderQualifier private val locationProvider: String?,
) {

    @SuppressLint("MissingPermission")
    fun requestLocation(listener: (LocationDataEntity) -> Unit) {
        locationProvider?.let { provider ->
            locationManager.requestLocationUpdates(
                provider,
                MIN_TIME,
                MIN_DISTANCE
            ) {
                val locationData = it.toLocationDataEntity()
                listener.invoke(locationData)
            }
        }
    }

    companion object {
        const val MIN_TIME = 1000L
        const val MIN_DISTANCE = 20F
    }
}
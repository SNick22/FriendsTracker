package com.example.data.datasources.remote.location.mapper

import android.location.Location
import com.example.data.datasources.remote.location.entity.LocationDataEntity

fun Location.toLocationDataEntity() =
    LocationDataEntity(
        longitude = longitude,
        latitude = latitude
    )
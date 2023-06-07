package com.example.friendstracker.glue.main.repositories.mapper

import com.example.data.datasources.remote.location.entity.LocationDataEntity
import com.example.main.domain.entity.LocationEntity

fun LocationDataEntity.toLocationEntity() = LocationEntity(
    longitude = longitude,
    latitude = latitude
)
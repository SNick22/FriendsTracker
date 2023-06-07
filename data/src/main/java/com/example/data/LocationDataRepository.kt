package com.example.data

import com.example.data.datasources.remote.location.entity.LocationDataEntity

interface LocationDataRepository {

    fun requestLocation(listener: (LocationDataEntity) -> Unit)
}
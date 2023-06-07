package com.example.data.location

import com.example.data.LocationDataRepository
import com.example.data.datasources.remote.location.LocationDataSource
import com.example.data.datasources.remote.location.entity.LocationDataEntity
import javax.inject.Inject

class RealLocationDataRepository @Inject constructor(
    private val dataSource: LocationDataSource
) : LocationDataRepository {

    override fun requestLocation(listener: (LocationDataEntity) -> Unit) {
        dataSource.requestLocation(listener)
    }
}
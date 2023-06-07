package com.example.friendstracker.glue.main.repositories

import com.example.data.LocationDataRepository
import com.example.friendstracker.glue.main.repositories.mapper.toLocationEntity
import com.example.main.domain.entity.LocationEntity
import com.example.main.domain.repositories.LocationRepository
import javax.inject.Inject

class AdapterLocationRepository @Inject constructor(
    private val repository: LocationDataRepository
) : LocationRepository {

    override fun requestLocation(listener: (LocationEntity) -> Unit) {
        repository.requestLocation {
            listener(it.toLocationEntity())
        }
    }
}
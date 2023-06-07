package com.example.main.domain.repositories

import com.example.main.domain.entity.LocationEntity

interface LocationRepository {

    fun requestLocation(listener: (LocationEntity) -> Unit)
}
package com.example.main.domain

import com.example.main.domain.entity.LocationEntity
import com.example.main.domain.repositories.LocationRepository
import javax.inject.Inject

class RequestLocationUseCase @Inject constructor(
    private val repository: LocationRepository
) {

    operator fun invoke(listener: (LocationEntity) -> Unit) {
        repository.requestLocation(listener)
    }
}
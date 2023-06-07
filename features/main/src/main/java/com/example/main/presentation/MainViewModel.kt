package com.example.main.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.main.MainRouter
import com.example.main.domain.RequestLocationUseCase
import com.example.main.domain.entity.LocationEntity
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val router: MainRouter,
    private val requestLocationUseCase: RequestLocationUseCase
) : ViewModel() {


    private val _currentLocation = MutableLiveData<Point?>(null)
    val currentLocation: LiveData<Point?>
        get() = _currentLocation

    private var _cameraPosition: CameraPosition? = null
    val cameraPosition: CameraPosition?
        get() = _cameraPosition

    fun toMessages() {
        router.launchMessages()
    }

    fun toProfile() {
        router.launchProfile()
    }

    fun updateCameraPosition(cameraPosition: CameraPosition) {
        _cameraPosition = cameraPosition
    }

    fun trackUserLocation() {
        requestLocationUseCase {
            _currentLocation.value = it.toPoint()
        }
    }

    private fun LocationEntity.toPoint() = Point(latitude, longitude)
}
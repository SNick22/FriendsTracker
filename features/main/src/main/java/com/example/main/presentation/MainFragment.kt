package com.example.main.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.common.presentation.getBitmapFromRes
import com.example.common.presentation.lazyViewModel
import com.example.common.presentation.requestLocationPermissions
import com.example.main.R
import com.example.main.databinding.FragmentMainBinding
import com.example.main.di.MainComponentHolder
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.MapObjectCollection
import com.yandex.mapkit.map.PlacemarkMapObject
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider

class MainFragment: Fragment(R.layout.fragment_main) {

    private var binding: FragmentMainBinding? = null

    private var mapView: MapView? = null

    private var myLocationPlacemark: PlacemarkMapObject? = null

    private val viewModel: MainViewModel by lazyViewModel {
        MainComponentHolder.get(requireContext())
            .mainViewModel()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requestLocationPermissions {
            viewModel.trackUserLocation()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.initialize(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)

        mapView = binding?.mapview

        viewModel.cameraPosition?.let {
            mapView?.map?.move(it)
        }

        binding?.setListeners()

        observeViewModel()

        hardcodePlacemarks()
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        mapView?.onStart()
    }

    override fun onStop() {
        super.onStop()
        MapKitFactory.getInstance().onStop()
        mapView?.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        mapView?.map?.cameraPosition?.let {
            viewModel.updateCameraPosition(it)
        }

        myLocationPlacemark = null
        mapView = null
        binding = null
    }

    private fun observeViewModel() {
        with(viewModel) {
            currentLocation.observe(viewLifecycleOwner) {
                it?.let { updateMyLocationPlacemark(it) }
            }
        }
    }

    private fun updateMyLocationPlacemark(point: Point) {
        getMyLocationPlacemark(point).geometry = point
    }

    private fun getMyLocationPlacemark(point: Point): PlacemarkMapObject =
        myLocationPlacemark ?: let {
            setMyLocationPlacemark(point)
            myLocationPlacemark!!
        }

    private fun setMyLocationPlacemark(point: Point) {
        myLocationPlacemark = mapView?.map?.mapObjects?.addPlacemark(
            point,
            ImageProvider.fromBitmap(getBitmapFromRes(R.drawable.my_location))
        )
    }

    private fun hardcodePlacemarks() {
        mapView?.map?.mapObjects?.run {
            addPlacemark(
                Point(55.7910655549299, 49.1217526195154),
                ImageProvider.fromBitmap(getBitmapFromRes(R.drawable.first_user))
            )
            addPlacemark(
                Point(55.817220, 49.107320),
                ImageProvider.fromBitmap(getBitmapFromRes(R.drawable.second_user))
            )
        }
    }

    private fun FragmentMainBinding.setListeners() {
        btnMyLocation.setOnClickListener {
            val point = viewModel.currentLocation.value
            point?.let {
                mapview.map.move(
                    CameraPosition(point, 15.0f, 0.0f, 0.0f),
                    Animation(Animation.Type.SMOOTH, 1f),
                    null
                )
            }
        }
        btnMessages.setOnClickListener {
            viewModel.toMessages()
        }
        btnProfile.setOnClickListener {
            viewModel.toProfile()
        }
    }
}
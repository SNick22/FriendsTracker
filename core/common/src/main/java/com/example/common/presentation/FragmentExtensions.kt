package com.example.common.presentation

import android.Manifest
import android.graphics.Bitmap
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

const val ARG_SCREEN = "screen"

inline fun <reified T : ViewModel> Fragment.lazyViewModel(
    noinline create: (stateHandle: SavedStateHandle) -> T
) = viewModels<T> {
    MainViewModelFactory(this, create)
}

fun Fragment.showToast(message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG)
        .show()
}

fun Fragment.getBitmapFromRes(@DrawableRes idRes: Int): Bitmap =
    AppCompatResources.getDrawable(requireContext(), idRes)
        ?.toBitmap()!!

@Suppress("DEPRECATION", "UNCHECKED_CAST")
fun <T : BaseScreen> Fragment.args(): T {
    return requireArguments().getSerializable(ARG_SCREEN) as? T
        ?: throw IllegalStateException("Screen args don't exist")
}

fun Fragment.requestLocationPermissions(onGrantedAction: () -> Unit) {
    val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {
        val allGranted = it.values.all { granted ->
            granted
        }
        if (allGranted) {
            onGrantedAction.invoke()
        }
    }

    requestPermissionLauncher.launch(
        arrayOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
    )
}

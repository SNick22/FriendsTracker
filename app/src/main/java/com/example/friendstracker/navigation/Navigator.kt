package com.example.friendstracker.navigation

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.navOptions
import com.example.common.presentation.ARG_SCREEN
import com.example.common.di.ApplicationScope
import java.io.Serializable
import javax.inject.Inject

@ApplicationScope
class Navigator @Inject constructor() {

    private var navController: NavController? = null

    fun setNavController(navController: NavController) {
        this.navController = navController
    }

    fun navigate(@IdRes destinationId: Int, args: Serializable? = null) {
        if (args == null) {
            navController?.navigate(destinationId)
        } else {
            navController?.navigate(destinationId, Bundle().apply {
                putSerializable(ARG_SCREEN, args)
            })
        }
    }

    fun navigateWithAnimation(@IdRes destinationId: Int) {
        navController?.navigate(
            resId = destinationId,
            args = null,
            navOptions = navOptions {
               anim {
                   exit = android.R.anim.fade_out
               }
            }
        )
    }

    fun back() {
        navController?.navigateUp()
    }

    fun navigateBackTo(@IdRes destinationId: Int) {
        navController?.popBackStack(destinationId, false)
    }
}
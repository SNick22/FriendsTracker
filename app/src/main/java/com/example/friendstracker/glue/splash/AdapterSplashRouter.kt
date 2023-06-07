package com.example.friendstracker.glue.splash

import com.example.friendstracker.R
import com.example.friendstracker.navigation.Navigator
import com.example.splash.SplashRouter
import javax.inject.Inject

class AdapterSplashRouter @Inject constructor(
    private val navigator: Navigator
) : SplashRouter{

    override fun launchAuthorisation() {
        navigator.navigateWithAnimation(R.id.enterNumberFragment)
    }

    override fun launchMain() {
        navigator.navigate(R.id.mainFragment)
    }
}
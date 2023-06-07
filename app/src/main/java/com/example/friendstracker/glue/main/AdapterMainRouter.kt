package com.example.friendstracker.glue.main

import com.example.friendstracker.R
import com.example.friendstracker.navigation.Navigator
import com.example.main.MainRouter
import javax.inject.Inject

class AdapterMainRouter @Inject constructor(
    private val navigator: Navigator
) : MainRouter {

    override fun launchMessages() {
        navigator.navigateWithAnimation(R.id.messagesFragment)
    }

    override fun launchProfile() {
        navigator.navigateWithAnimation(R.id.profileFragment)
    }
}
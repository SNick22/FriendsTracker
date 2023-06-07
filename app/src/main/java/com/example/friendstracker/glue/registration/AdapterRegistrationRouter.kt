package com.example.friendstracker.glue.registration

import com.example.friendstracker.R
import com.example.friendstracker.navigation.Navigator
import com.example.registration.RegistrationRouter
import javax.inject.Inject

class AdapterRegistrationRouter @Inject constructor(
    private val navigator: Navigator,
) : RegistrationRouter {

    override fun launchSplash() {
        navigator.navigateBackTo(R.id.splashFragment)
    }
}
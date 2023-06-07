package com.example.friendstracker.glue.authorisation

import com.example.authorisation.EnterAuthorisationCodeRouter
import com.example.friendstracker.R
import com.example.friendstracker.navigation.Navigator
import javax.inject.Inject

class AdapterEnterAuthorisationCodeRouter @Inject constructor(
    private val navigator: Navigator
): EnterAuthorisationCodeRouter {

    override fun launchMain() {
        navigator.navigate(R.id.mainFragment)
    }

    override fun launchRegistration() {
        navigator.navigate(R.id.registrationFragment)
    }

    override fun back() {
        navigator.back()
    }
}
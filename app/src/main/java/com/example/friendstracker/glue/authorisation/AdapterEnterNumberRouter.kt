package com.example.friendstracker.glue.authorisation

import com.example.authorisation.EnterNumberRouter
import com.example.authorisation.presentation.enter_authorisation_code.EnterAuthorisationCodeFragment
import com.example.friendstracker.R
import com.example.friendstracker.navigation.Navigator
import javax.inject.Inject

class AdapterEnterNumberRouter @Inject constructor(
    private val navigator: Navigator
): EnterNumberRouter {

    override fun launchCode(phoneNumber: String) {
        navigator.navigate(
            R.id.enterAuthorisationCodeFragment,
            EnterAuthorisationCodeFragment.Screen(phoneNumber)
        )
    }
}
package com.example.splash.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.theme.R
import com.example.splash.SplashRouter
import com.example.splash.domain.IsSignedInUseCase
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val router: SplashRouter,
    private val isSignedInUseCase: IsSignedInUseCase
) : ViewModel() {

    private val _message = MutableLiveData<Int?>(null)
    val message: LiveData<Int?>
        get() = _message

    fun openNextScreen() {
        viewModelScope.launch {
            try {
                if (isSignedInUseCase()) {
                    router.launchMain()
                } else {
                    router.launchAuthorisation()
                }
            } catch (e: Exception) {
                _message.value = R.string.network_error
            }
        }
    }
}
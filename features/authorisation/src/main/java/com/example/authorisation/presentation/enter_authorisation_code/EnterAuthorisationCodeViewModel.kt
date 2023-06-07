package com.example.authorisation.presentation.enter_authorisation_code

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.authorisation.EnterAuthorisationCodeRouter
import com.example.authorisation.R
import com.example.authorisation.domain.IsSignedUpUseCase
import com.example.authorisation.domain.CheckAuthorisationCodeUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class EnterAuthorisationCodeViewModel @AssistedInject constructor(
    @Assisted private val screen: EnterAuthorisationCodeFragment.Screen,
    private val checkAuthorisationCodeUseCase: CheckAuthorisationCodeUseCase,
    private val isSignedUpUseCase: IsSignedUpUseCase,
    private val router: EnterAuthorisationCodeRouter,
) : ViewModel() {

    val phoneNumber: String
        get() = screen.phoneNumber

    private val _message = MutableLiveData<Int?>(null)
    val message: LiveData<Int?>
        get() = _message

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun sendCode(code: String) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                if (checkAuthorisationCodeUseCase(code)) {
                    if (isSignedUpUseCase()) {
                        router.launchMain()
                    } else {
                        router.launchRegistration()
                    }
                } else {
                    _message.value = R.string.wrong_code
                }
            } catch (e: Exception) {
                _message.value = com.example.theme.R.string.network_error
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun navigateBack() {
        router.back()
    }

    @AssistedFactory
    interface Factory {
        fun create(
            @Assisted screen: EnterAuthorisationCodeFragment.Screen
        ): EnterAuthorisationCodeViewModel
    }
}
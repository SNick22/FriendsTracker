package com.example.authorisation.presentation.enter_number

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.authorisation.EnterNumberRouter
import com.example.authorisation.R
import com.example.authorisation.domain.SendPhoneNumberUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class EnterNumberViewModel @Inject constructor(
    private val sendPhoneNumberUseCase: SendPhoneNumberUseCase,
    private val router: EnterNumberRouter,
): ViewModel() {

    private val _message = MutableLiveData<Int?>(null)
    val message: LiveData<Int?>
        get() = _message

    private val _textInputError = MutableLiveData<Int?>(null)
    val textInputError: LiveData<Int?>
        get() = _textInputError

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun getAuthorisationCode(phone: String) {
        if (isPhoneValid(phone)) {
            viewModelScope.launch {
                try {
                    _isLoading.value = true
                    sendPhoneNumberUseCase(phone)
                    router.launchCode(phone)
                } catch (e: Exception) {
                    _message.value = com.example.theme.R.string.network_error
                } finally {
                    _isLoading.value = false
                }
            }
        } else {
            _textInputError.value = R.string.phone_incorrect
        }
    }

    private fun isPhoneValid(phone: String): Boolean {
        val regex = Regex("^79\\d{9}$")
        return regex.matches(phone)
    }
}
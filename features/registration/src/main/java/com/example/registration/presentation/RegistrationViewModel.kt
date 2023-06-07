package com.example.registration.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registration.R
import com.example.registration.RegistrationRouter
import com.example.registration.domain.IsUsernameAvailableUseCase
import com.example.registration.domain.RegisterUserUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class RegistrationViewModel @Inject constructor(
    private val isUsernameAvailableUseCase: IsUsernameAvailableUseCase,
    private val registerUserUseCase: RegisterUserUseCase,
    private val router: RegistrationRouter,
) : ViewModel() {

    private val _message = MutableLiveData<Int?>(null)
    val message: LiveData<Int?>
        get() = _message

    private val _usernameTextInputError = MutableLiveData<Int?>(null)
    val usernameTextInputError: LiveData<Int?>
        get() = _usernameTextInputError

    private val _nameTextInputError = MutableLiveData<Int?>(null)
    val nameTextInputError: LiveData<Int?>
        get() = _nameTextInputError

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun finishRegistration(username: String, name: String) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                if (isUsernameValid(username) && isNameValid(name)) {
                    registerUserUseCase(username, name)
                    router.launchSplash()
                }
            } catch (e: Exception) {
                _message.value = com.example.theme.R.string.network_error
            } finally {
                _isLoading.value = false
            }
        }
    }

    private suspend fun isUsernameValid(username: String): Boolean {
        if (username.isEmpty()) {
            _usernameTextInputError.value = R.string.empty_username
            return false
        }
        if (!isUsernameAvailableUseCase(username)) {
            _usernameTextInputError.value = R.string.busy_username
            return false
        }
        _usernameTextInputError.value = null
        return true
    }

    private fun isNameValid(name: String): Boolean {
        if (name.isEmpty()) {
            _nameTextInputError.value = R.string.empty_name
            return false
        }
        _nameTextInputError.value = null
        return true
    }
}
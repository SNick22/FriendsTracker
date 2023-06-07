package com.example.registration.domain

import com.example.registration.domain.repositories.AccountRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class IsUsernameAvailableUseCase @Inject constructor(
    private val repository: AccountRepository,
) {

    suspend operator fun invoke(username: String) = withContext(Dispatchers.IO) {
        repository.isUsernameAvailable(username)
    }
}
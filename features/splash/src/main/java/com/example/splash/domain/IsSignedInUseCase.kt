package com.example.splash.domain

import com.example.splash.domain.repositories.AccountRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class IsSignedInUseCase @Inject constructor(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(): Boolean = withContext(Dispatchers.IO) {
        repository.isSignedIn()
    }
}
package com.example.authorisation.domain

import com.example.authorisation.domain.repositories.AccountRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CheckAuthorisationCodeUseCase @Inject constructor(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(code: String): Boolean = withContext(Dispatchers.IO) {
        repository.checkAuthorisationCode(code)
    }
}
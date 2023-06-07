package com.example.authorisation.domain

import com.example.authorisation.domain.repositories.AccountRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SendPhoneNumberUseCase @Inject constructor(
    private val repository: AccountRepository
) {

    suspend operator fun invoke(phoneNumber: String) {
        withContext(Dispatchers.IO) {
            repository.sendPhoneNumber(phoneNumber)
        }
    }
}
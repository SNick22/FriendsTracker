package com.example.friendstracker.glue.authorisation.repositories

import com.example.authorisation.domain.repositories.AccountRepository
import com.example.data.AccountDataRepository
import javax.inject.Inject

class AdapterAccountRepository @Inject constructor(
    private val repository: AccountDataRepository
): AccountRepository {

    override suspend fun sendPhoneNumber(phoneNumber: String) {
        repository.sendPhoneNumber(phoneNumber)
    }

    override suspend fun checkAuthorisationCode(code: String) =
        repository.checkAuthorisationCode(code)

    override suspend fun isSignedUp() = repository.isSignedUp()
}
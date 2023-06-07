package com.example.friendstracker.glue.registration.repositories

import com.example.registration.domain.repositories.AccountRepository
import com.example.data.AccountDataRepository
import javax.inject.Inject

class AdapterAccountRepository @Inject constructor(
    private val repository: AccountDataRepository
): AccountRepository {

    override suspend fun isUsernameAvailable(username: String): Boolean =
        repository.isUsernameAvailable(username)

    override suspend fun registerUser(username: String, name: String) {
        repository.registerUser(username, name)
    }
}
package com.example.friendstracker.glue.splash.repositories

import com.example.data.AccountDataRepository
import com.example.splash.domain.repositories.AccountRepository
import javax.inject.Inject

class AdapterAccountRepository @Inject constructor(
    private val repository: AccountDataRepository
): AccountRepository {

    override suspend fun isSignedIn(): Boolean = repository.isSignedIn()
}
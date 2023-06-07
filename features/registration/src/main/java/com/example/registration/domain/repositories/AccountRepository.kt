package com.example.registration.domain.repositories

interface AccountRepository {

    suspend fun isUsernameAvailable(username: String): Boolean

    suspend fun registerUser(username: String, name: String)
}
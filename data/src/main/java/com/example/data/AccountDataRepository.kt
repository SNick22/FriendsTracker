package com.example.data

interface AccountDataRepository {

    suspend fun isSignedIn(): Boolean

    suspend fun sendPhoneNumber(phoneNumber: String)

    suspend fun checkAuthorisationCode(code: String): Boolean

    suspend fun isSignedUp(): Boolean

    suspend fun isUsernameAvailable(username: String): Boolean

    suspend fun registerUser(username: String, name: String)
}
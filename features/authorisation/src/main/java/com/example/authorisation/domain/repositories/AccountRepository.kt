package com.example.authorisation.domain.repositories

interface AccountRepository {

    suspend fun sendPhoneNumber(phoneNumber: String)

    suspend fun checkAuthorisationCode(code: String): Boolean

    suspend fun isSignedUp(): Boolean
}
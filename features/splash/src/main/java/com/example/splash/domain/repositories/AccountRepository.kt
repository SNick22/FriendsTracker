package com.example.splash.domain.repositories

interface AccountRepository {

    suspend fun isSignedIn(): Boolean
}
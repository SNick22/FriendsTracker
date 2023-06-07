package com.example.data.account

import com.example.common.utils.checkAllNotNull
import com.example.data.AccountDataRepository
import com.example.data.datasources.local.sharedpreferences.SharedPreferencesDataSource
import com.example.data.datasources.remote.network.account.AccountApi
import com.example.data.datasources.remote.network.account.data.PhoneNumberData
import com.example.data.datasources.remote.network.account.data.UserData
import java.lang.IllegalStateException
import javax.inject.Inject

class RealAccountDataRepository @Inject constructor(
    private val sharedPreferencesDataSource: SharedPreferencesDataSource,
    private val api: AccountApi,
) : AccountDataRepository {

    override suspend fun isSignedIn(): Boolean {
        val authToken = sharedPreferencesDataSource.getString(AUTH_TOKEN_KEY)
        val phoneNumber = sharedPreferencesDataSource.getString(PHONE_NUMBER_KEY)

        return if (checkAllNotNull(authToken, phoneNumber)) {
            api.isSignedIn(phoneNumber!!, authToken!!).status ?: false
        } else {
            false
        }
    }

    override suspend fun sendPhoneNumber(phoneNumber: String) {
        sharedPreferencesDataSource.putString(PHONE_NUMBER_KEY, phoneNumber)
        api.sendPhoneNumber(
            PhoneNumberData(phoneNumber)
        )
    }

    override suspend fun checkAuthorisationCode(code: String): Boolean {
        val phoneNumber = sharedPreferencesDataSource.getString(PHONE_NUMBER_KEY) ?:
            throw IllegalStateException("No phone number")
        val token = api.checkAuthorisationCode(phoneNumber, code)
        token.authToken?.let {
            sharedPreferencesDataSource.putString(AUTH_TOKEN_KEY, it)
            return true
        }
        return false
    }

    override suspend fun isSignedUp(): Boolean {
        val phoneNumber = sharedPreferencesDataSource.getString(PHONE_NUMBER_KEY)
            ?: throw IllegalStateException("No phone number")
        return api.isSignedUp(phoneNumber).status ?: throw IllegalStateException("Network error")
    }

    override suspend fun isUsernameAvailable(username: String): Boolean {
        return api.isUsernameAvailable(username).status ?: throw IllegalStateException("Network error")
    }

    override suspend fun registerUser(username: String, name: String) {
        val authToken = sharedPreferencesDataSource.getString(AUTH_TOKEN_KEY) ?:
            throw IllegalStateException("No auth token")
        val phoneNumber = sharedPreferencesDataSource.getString(PHONE_NUMBER_KEY) ?:
            throw IllegalStateException("No phone number")

        api.registerUser(
            UserData(
                phoneNumber = phoneNumber,
                authToken = authToken,
                login = username,
                name = name
            )
        )
    }

    private companion object {
        const val AUTH_TOKEN_KEY = "auth_token"
        const val PHONE_NUMBER_KEY = "phone_number"
    }
}
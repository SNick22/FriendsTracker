package com.example.data.datasources.remote.network.account

import com.example.data.datasources.remote.network.account.data.PhoneNumberData
import com.example.data.datasources.remote.network.account.data.UserData
import com.example.data.datasources.remote.network.account.response.AuthTokenResponse
import com.example.data.datasources.remote.network.account.response.StatusResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AccountApi {

    @GET("check-auth")
    suspend fun isSignedIn(
        @Query("phone_number") phoneNumber: String,
        @Query("auth_token") authToken: String,
    ): StatusResponse

    @POST("send-auth-code")
    suspend fun sendPhoneNumber(
        @Body data: PhoneNumberData
    )

    @GET("check-auth-code")
    suspend fun checkAuthorisationCode(
        @Query("phone_number") phoneNumber: String,
        @Query("auth_code") code: String
    ): AuthTokenResponse

    @GET("check-registration")
    suspend fun isSignedUp(
        @Query("phone_number") phoneNumber: String,
    ): StatusResponse

    @GET("check-login")
    suspend fun isUsernameAvailable(
        @Query("login") username: String,
    ): StatusResponse

    @POST("register-user")
    suspend fun registerUser(
        @Body data: UserData
    )
}
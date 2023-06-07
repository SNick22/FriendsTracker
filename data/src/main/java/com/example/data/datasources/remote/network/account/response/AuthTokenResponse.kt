package com.example.data.datasources.remote.network.account.response

import com.google.gson.annotations.SerializedName

data class AuthTokenResponse(
    @SerializedName("auth_token")
    val authToken: String?
)

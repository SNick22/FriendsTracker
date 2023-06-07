package com.example.data.datasources.remote.network.account.data

import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("phone_number")
    val phoneNumber: String,
    @SerializedName("auth_token")
    val authToken: String,
    @SerializedName("login")
    val login: String,
    @SerializedName("name")
    val name: String
)

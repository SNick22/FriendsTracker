package com.example.data.datasources.remote.network.account.data

import com.google.gson.annotations.SerializedName

data class PhoneNumberData(
    @SerializedName("phone_number")
    val phoneNumber: String
)

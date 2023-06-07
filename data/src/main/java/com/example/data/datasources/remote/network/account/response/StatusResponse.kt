package com.example.data.datasources.remote.network.account.response

import com.google.gson.annotations.SerializedName

data class StatusResponse(
    @SerializedName("status")
    val status: Boolean?
)

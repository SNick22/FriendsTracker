package com.example.data.datasources.local.sharedpreferences

import android.content.Context
import javax.inject.Inject

class SharedPreferencesDataSource @Inject constructor(
    context: Context
) {

    private val sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)

    fun getString(key: String) = sharedPreferences.getString(key, null)

    fun putString(key: String, value: String) {
        sharedPreferences.edit()
            .putString(key, value)
            .apply()
    }

    private companion object {
        const val SP_NAME = "friends_tracker"
    }
}
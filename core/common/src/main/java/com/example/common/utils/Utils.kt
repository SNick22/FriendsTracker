package com.example.common.utils

fun checkAllNotNull(vararg objects: Any?): Boolean {
    return objects.all { it != null }
}

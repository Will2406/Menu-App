package com.android.menu.data.core


import com.squareup.moshi.Moshi

inline fun <reified T> T.toJson(): String {
    val moshi = Moshi.Builder().build()
    val matchAdapter = moshi.adapter(T::class.java)
    return matchAdapter.toJson(this)
}

inline fun <reified T> String.fromJson(): T? {
    return try {
        val moshi = Moshi.Builder().build()
        val matchAdapter = moshi.adapter(T::class.java)
        matchAdapter.fromJson(this)
    } catch (_: Exception) {
        null
    }
}



package com.yape.domain.core

import com.yape.data.core.fromJson
import com.yape.data.core.toJson

inline fun <reified T> T.toJson(): String {
    return T::class.java.toJson()
}

inline fun <reified T> String.fromJson(): T? {
    return this.fromJson<T>()
}



package com.android.menu.data.remote.model

import android.net.Uri
import com.android.menu.data.local.preferences.UserEntity

data class UserResponse(
    val uid: String,
    val image: Uri?,
    val name: String?,
    val email: String?
)

fun UserResponse.convertToEntity() = UserEntity(
    id = uid,
    image = image.toString(),
    name = name,
    email = email
)
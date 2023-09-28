package com.android.menu.data.remote.model

import android.net.Uri

data class UserResponse(
    val uid: String,
    val image: Uri?,
    val name: String?,
    val email: String?
)
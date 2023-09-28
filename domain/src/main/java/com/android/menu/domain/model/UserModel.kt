package com.android.menu.domain.model

import android.net.Uri
import com.android.menu.data.remote.model.UserResponse

data class UserModel(var id: String, var name: String? = "", var email: String? = "", var photo: Uri?)


fun UserResponse.convertToModel() = UserModel(
    id = uid,
    name = name,
    email = email,
    photo = image
)
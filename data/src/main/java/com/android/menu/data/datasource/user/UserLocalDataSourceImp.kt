package com.android.menu.data.datasource.user

import android.content.SharedPreferences
import com.android.menu.data.core.toJson
import com.android.menu.data.local.preferences.UserEntity
import javax.inject.Inject

class UserLocalDataSourceImp @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : UserLocalDataSource {

    companion object {
        const val USER = "user"
    }

    override fun saveUserData(user: UserEntity) {
        sharedPreferences.edit().putString(USER, user.toJson()).apply()
    }

}
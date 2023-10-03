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
        const val LOGIN_SUCCESSFUL = "loginSuccessful"
    }

    override fun saveUserData(user: UserEntity) {
        sharedPreferences.edit().putString(USER, user.toJson()).apply()
    }

    override fun saveLoginSuccessful(isSuccess: Boolean) {
        sharedPreferences.edit().putBoolean(LOGIN_SUCCESSFUL, isSuccess).apply()
    }

    override fun getValidatedSession(): Boolean {
        return sharedPreferences.getBoolean(LOGIN_SUCCESSFUL, false)
    }

}
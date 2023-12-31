package com.android.menu.data.datasource.user

import android.content.Intent
import com.android.menu.data.local.preferences.UserEntity
import com.android.menu.data.remote.model.UserResponse
import kotlinx.coroutines.flow.Flow

interface UserRemoteDataSource {
    suspend fun googleSignInClient(): Intent
    suspend fun signInWithGoogleCredential(intent: Intent): Flow<UserResponse?>
    suspend fun createUserWithEmailAndPassword(email: String, password: String): Flow<UserResponse?>
}

interface UserLocalDataSource {
    fun saveUserData(user: UserEntity)
    fun saveLoginSuccessful(isSuccess: Boolean)
    fun getValidatedSession(): Boolean
}
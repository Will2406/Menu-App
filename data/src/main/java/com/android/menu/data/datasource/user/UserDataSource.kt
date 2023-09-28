package com.android.menu.data.datasource.user

import android.content.Intent
import com.android.menu.data.remote.model.UserResponse
import kotlinx.coroutines.flow.Flow

interface UserRemoteDataSource {
    suspend fun googleSignInClient(): Intent
    suspend fun signInWithGoogleCredential(intent: Intent): Flow<UserResponse?>
}

interface UserLocalDataSource {}
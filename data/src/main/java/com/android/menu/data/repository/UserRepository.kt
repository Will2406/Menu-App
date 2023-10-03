package com.android.menu.data.repository

import android.content.Intent
import com.android.menu.data.datasource.user.UserLocalDataSource
import com.android.menu.data.datasource.user.UserRemoteDataSource
import com.android.menu.data.remote.model.convertToEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val remote: UserRemoteDataSource,
    private val local: UserLocalDataSource
) {

    suspend fun getGoogleSignInClient() = remote.googleSignInClient()

    suspend fun loginWithGoogle(intent: Intent): Flow<Boolean> = flow {
        remote.signInWithGoogleCredential(intent)
            .collect { userFromGoogle ->
                userFromGoogle?.let { local.saveUserData(it.convertToEntity()) }
                val checkLoginUser = userFromGoogle != null
                local.saveLoginSuccessful(checkLoginUser)
                emit(checkLoginUser)
            }
    }.flowOn(Dispatchers.IO)

    suspend fun checkSession() = local.getValidatedSession()

}

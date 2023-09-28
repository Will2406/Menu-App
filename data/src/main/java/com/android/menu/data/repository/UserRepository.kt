package com.android.menu.data.repository

import android.content.Intent
import com.android.menu.data.datasource.user.UserRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val remote: UserRemoteDataSource
) {

    suspend fun getGoogleSignInClient() = remote.googleSignInClient()

    suspend fun loginWithGoogle(intent: Intent): Flow<Boolean> = flow {
        remote.signInWithGoogleCredential(intent)
            .collect { userFromGoogle ->
                userFromGoogle?.let {
                    //saveUserData
                }
                emit(userFromGoogle != null)
            }
    }.flowOn(Dispatchers.IO)

}

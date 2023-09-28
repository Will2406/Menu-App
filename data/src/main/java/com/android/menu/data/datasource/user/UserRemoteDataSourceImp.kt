package com.android.menu.data.datasource.user

import android.content.Context
import android.content.Intent
import com.android.menu.data.R
import com.android.menu.data.remote.model.UserResponse
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import javax.inject.Inject

class UserRemoteDataSourceImpl @Inject constructor(
    private val context: Context,
    private val auth: FirebaseAuth
) : UserRemoteDataSource {


    private val googleSignInClient: GoogleSignInClient by lazy {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(context.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        GoogleSignIn.getClient(context, gso)
    }

    override suspend fun googleSignInClient(): Intent {
        return googleSignInClient.signInIntent
    }

    override suspend fun signInWithGoogleCredential(intent: Intent): Flow<UserResponse?> {
        val account = GoogleSignIn.getSignedInAccountFromIntent(intent)
        return if (account.isSuccessful) {
            val credential = GoogleAuthProvider.getCredential(account.result.idToken, null)
            val firebaseUser = auth.signInWithCredential(credential).await()

            flow {
                firebaseUser.user?.let {
                    emit(
                        UserResponse(
                            uid = it.uid,
                            name = it.displayName,
                            image = it.photoUrl,
                            email = it.email
                        )
                    )
                } ?: emit(null)
            }
        } else {
            throw Exception("Sign in with Google failed.")
        }

    }

}


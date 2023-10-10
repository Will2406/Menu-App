package com.android.menu.domain.usecase

import android.content.Intent
import com.android.menu.data.repository.UserRepository
import com.android.menu.domain.core.UseCase
import javax.inject.Inject

class GetGoogleSignInClient @Inject constructor(
    private val userRepository: UserRepository
) : UseCase.WithoutParams<Intent> {

    override suspend fun invoke(): Intent {
        return userRepository.getGoogleSignInClient()
    }
}
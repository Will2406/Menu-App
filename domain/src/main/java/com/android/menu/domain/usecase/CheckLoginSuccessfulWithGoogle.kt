package com.android.menu.domain.usecase

import android.content.Intent
import com.android.menu.data.repository.UserRepository
import com.android.menu.domain.core.UseCase
import com.android.menu.domain.model.UserModel
import com.android.menu.domain.model.convertToModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CheckLoginSuccessfulWithGoogle @Inject constructor(
    private val repository: UserRepository
) : UseCase.WithParams<Intent, Flow<Boolean>> {

    override suspend fun invoke(params: Intent): Flow<Boolean> {
        return repository.loginWithGoogle(intent = params)
    }
}
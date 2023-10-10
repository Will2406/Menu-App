package com.android.menu.domain.usecase

import com.android.menu.data.repository.UserRepository
import com.android.menu.domain.core.UseCase
import com.android.menu.domain.model.UserParameter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RegisterUser @Inject constructor(
    private val repository: UserRepository
) : UseCase.WithParams<UserParameter, Flow<Boolean>> {

    override suspend fun invoke(params: UserParameter): Flow<Boolean> {
        return repository.registerUser(email = params.email, password = params.password)
    }
}
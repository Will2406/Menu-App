package com.android.menu.domain.usecase

import com.android.menu.data.repository.UserRepository
import com.android.menu.domain.core.UseCase
import javax.inject.Inject

class CheckSession @Inject constructor(
    private val repository: UserRepository
) : UseCase.WithoutParams<Boolean> {

    override suspend fun invoke(): Boolean {
        return repository.checkSession()
    }

}
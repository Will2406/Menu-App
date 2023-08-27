package com.yape.menu.domain.util

sealed interface UseCase{

    interface WithParams<Parameters, Result>: UseCase {
        suspend operator fun invoke(params: Parameters): Result
    }

    interface WithoutParams<Result>: UseCase {
        suspend operator fun invoke(): Result
    }

    interface OptionalParams<Parameters, Result>: UseCase {
        suspend operator fun invoke(params: Parameters? = null): Result
    }

    interface WithoutResult<Parameters>: UseCase {
        suspend operator fun invoke(params: Parameters)
    }

    interface Empty: UseCase {
        suspend operator fun invoke()
    }
}
package com.yape.menu.data.generics

import android.util.Log
import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Response

suspend fun <T : Any> safeApiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    apiCall: suspend () -> Response<T>
): DataResult<T> {

    val moshi = Moshi.Builder().build()
    val errorAdapter = moshi.adapter(HttpErrorResponse::class.java)

    return withContext(dispatcher) {
        try {
            val result = apiCall()
            if (result.isSuccessful) {
                DataResult.Success(data = result.body()!!)
            } else {
                val httpError =
                    result.errorBody()?.stringSuspending()?.let { errorAdapter.fromJson(it) }
                DataError.HttpError(
                    code = result.code(),
                    message = httpError?.message ?: httpError?.errors?.get(0),
                    body = result.errorBody()?.stringSuspending()
                )
            }
        } catch (ex: Exception) {
            Log.d("SAFE API CALL", ex.message.toString())
            DataError.HttpError(
                code = 0,
                message = ex.message,
                body = ""
            )
        }
    }
}

@Suppress("BlockingMethodInNonBlockingContext")
internal suspend fun ResponseBody.stringSuspending() =
    withContext(Dispatchers.IO) { string() }

data class HttpErrorResponse(
    @field:Json(name = "status") val status: Boolean?,
    @field:Json(name = "error") val errors: List<String>?,
    @field:Json(name = "message") val message: String?
)

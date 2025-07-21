@file:Suppress("SwallowedException", "TooGenericExceptionCaught", "MagicNumber")

package com.aytachuseynli.news_kmp.core.util


import com.aytachuseynli.news_kmp.core.domain.ApiException
import com.aytachuseynli.news_kmp.core.domain.NewsResult
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
suspend inline fun <reified T> safeCall(
    execute: () -> HttpResponse
): NewsResult<T> {
    val response = try {
        execute()
    } catch(e: SocketTimeoutException) {
        return NewsResult.Error(ApiException(code = 408, message = "Request timeout"))
    } catch(e: UnresolvedAddressException) {
        return NewsResult.Error(ApiException(code = -1, message = "No internet connection"))
    } catch (e: Exception) {
        return NewsResult.Error(e)
    }

    return responseToResult(response)
}

suspend inline fun <reified T> responseToResult(
    response: HttpResponse
): NewsResult<T> {
    return when(response.status.value) {
        in 200..299 -> {
            try {
                NewsResult.Success(response.body<T>())
            } catch(e: NoTransformationFoundException) {
                NewsResult.Error(ApiException(code = -1, message = "Serialization error"))
            }
        }
        408 -> NewsResult.Error(ApiException(code = 408, message = "Request timeout"))
        429 -> NewsResult.Error(ApiException(code = 429, message = "Too many requests"))
        in 500..599 -> NewsResult.Error(ApiException(code = response.status.value, message = "Server error"))
        else -> NewsResult.Error(ApiException(code = response.status.value, message = "Unknown error"))
    }
}

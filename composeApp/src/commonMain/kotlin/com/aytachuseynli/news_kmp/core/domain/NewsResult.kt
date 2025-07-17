package com.aytachuseynli.news_kmp.core.domain

sealed interface NewsResult<out T> {
    data class Success<out T>(val data: T) : NewsResult<T>

    data class Error(
        val error: Throwable,
        val message: String? = error.message
    ) : NewsResult<Nothing>
}

inline fun <T, R> NewsResult<T>.map(transform: (T) -> R): NewsResult<R> = when(this) {
    is NewsResult.Success -> NewsResult.Success(transform(data))
    is NewsResult.Error -> this
}

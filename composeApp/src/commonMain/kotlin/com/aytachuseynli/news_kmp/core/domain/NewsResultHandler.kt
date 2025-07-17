package com.aytachuseynli.news_kmp.core.domain

interface NewsResultHandler<T> {
    suspend fun onSuccess(block: suspend (data: T) -> Unit)
    fun onError(block: (error: Throwable, message: String?) -> Unit)
}

suspend fun <T> NewsResult<T>.handle(builder: suspend NewsResultHandler<T>.() -> Unit) {
    val handler = object : NewsResultHandler<T> {
        override suspend fun onSuccess(block: suspend (T) -> Unit) {
            if (this@handle is NewsResult.Success) {
                block(this@handle.data)
            }
        }

        override fun onError(block: (error: Throwable, message: String?) -> Unit) {
            if (this@handle is NewsResult.Error) {
                block(this@handle.error, this@handle.message)
            }
        }
    }
    builder(handler)
}

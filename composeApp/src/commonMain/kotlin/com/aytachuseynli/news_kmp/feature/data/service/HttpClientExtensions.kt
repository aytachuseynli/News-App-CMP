package com.aytachuseynli.news_kmp.feature.data.service

import com.aytachuseynli.news_kmp.core.domain.NewsResult
import com.aytachuseynli.news_kmp.core.util.safeCall
import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.parameter

suspend inline fun <reified T> HttpClient.getWithAuth(
    url: String,
    crossinline block: HttpRequestBuilder.() -> Unit = {}
): NewsResult<T> = safeCall {
    get(url) {
        parameter("apiKey", NewsApiConfig.getApiKey())
        block()
    }
}
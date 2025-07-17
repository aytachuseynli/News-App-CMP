package com.aytachuseynli.news_kmp.feature.data.service

object NewsApiConfig {
    const val BASE_URL = "https://newsapi.org/v2/"
    const val API_KEY  = "0b3cfc2eba53431e8a2442628c3c4253"

    enum class Endpoint(val path: String) {
        TOP_HEADLINES("/top-headlines"),
        EVERYTHING("/everything"),
        SOURCES("/top-headlines/sources")
    }

    fun buildUrl(endpoint: Endpoint): String = "$BASE_URL${endpoint.path}"
    fun getApiKey(): String = API_KEY
}
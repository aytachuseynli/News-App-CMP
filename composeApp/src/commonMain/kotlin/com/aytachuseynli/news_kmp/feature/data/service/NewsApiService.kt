package com.aytachuseynli.news_kmp.feature.data.service

import com.aytachuseynli.news_kmp.core.domain.NewsResult
import com.aytachuseynli.news_kmp.feature.data.dto.NewsResponseDto
import com.aytachuseynli.news_kmp.feature.data.dto.TrendsResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter

class NewsApiService(
    private val client: HttpClient
) : NewsApiClient {

    override suspend fun getTopHeadlines(country: String): NewsResult<NewsResponseDto> =
        client.getWithAuth(NewsApiConfig.buildUrl(NewsApiConfig.Endpoint.TOP_HEADLINES)) {
            parameter("country", country)
        }

    override suspend fun searchEverything(query: String): NewsResult<NewsResponseDto> =
        client.getWithAuth(NewsApiConfig.buildUrl(NewsApiConfig.Endpoint.EVERYTHING)) {
            parameter("q", query)
        }

    override suspend fun getSources(category: String?): NewsResult<TrendsResponseDto> =
        client.getWithAuth(NewsApiConfig.buildUrl(NewsApiConfig.Endpoint.SOURCES)) {
            category?.let { parameter("category", it) }
        }
}

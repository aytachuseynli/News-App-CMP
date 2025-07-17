package com.aytachuseynli.news_kmp.feature.data.service

import com.aytachuseynli.news_kmp.core.domain.NewsResult
import com.aytachuseynli.news_kmp.feature.data.dto.NewsResponseDto
import com.aytachuseynli.news_kmp.feature.data.dto.TrendsResponseDto

interface NewsApiClient {
    suspend fun getTopHeadlines(country: String): NewsResult<NewsResponseDto>
    suspend fun searchEverything(query: String): NewsResult<NewsResponseDto>
    suspend fun getSources(category: String? = null): NewsResult<TrendsResponseDto>
}
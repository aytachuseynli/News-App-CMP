package com.aytachuseynli.news_kmp.feature.domain.usecase

import com.aytachuseynli.news_kmp.core.domain.NewsResult
import com.aytachuseynli.news_kmp.feature.domain.model.Trends
import com.aytachuseynli.news_kmp.feature.domain.repository.NewsRepository

class TrendsUseCase(private val repo: NewsRepository) {
    suspend operator fun invoke(): NewsResult<List<Trends>> =
        repo.trends()
}

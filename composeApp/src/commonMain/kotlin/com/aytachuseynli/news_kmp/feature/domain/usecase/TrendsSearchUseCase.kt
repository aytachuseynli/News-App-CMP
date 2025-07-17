package com.aytachuseynli.news_kmp.feature.domain.usecase

import com.aytachuseynli.news_kmp.core.domain.NewsResult
import com.aytachuseynli.news_kmp.feature.domain.model.Trends
import com.aytachuseynli.news_kmp.feature.domain.repository.NewsRepository

class TrendsSearchUseCase(private val repo: NewsRepository) {
    suspend operator fun invoke(category: String): NewsResult<List<Trends>> =
        repo.trendsSearch(category = category)
}

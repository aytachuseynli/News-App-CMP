package com.aytachuseynli.news_kmp.feature.domain.usecase

import com.aytachuseynli.news_kmp.core.domain.NewsResult
import com.aytachuseynli.news_kmp.feature.domain.model.Article
import com.aytachuseynli.news_kmp.feature.domain.repository.NewsRepository

class SearchNewsUseCase(private val repo: NewsRepository) {
    suspend operator fun invoke(query: String): NewsResult<List<Article>> =
        repo.search(query)
}

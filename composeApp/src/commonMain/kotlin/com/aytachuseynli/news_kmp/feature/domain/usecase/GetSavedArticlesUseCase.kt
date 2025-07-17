package com.aytachuseynli.news_kmp.feature.domain.usecase

import com.aytachuseynli.news_kmp.feature.domain.model.Article
import com.aytachuseynli.news_kmp.feature.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedArticlesUseCase(private val repo: NewsRepository) {
    operator fun invoke(): Flow<List<Article>> = repo.getSavedArticles()
}
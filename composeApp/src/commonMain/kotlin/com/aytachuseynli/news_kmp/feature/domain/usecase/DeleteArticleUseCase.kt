package com.aytachuseynli.news_kmp.feature.domain.usecase

import com.aytachuseynli.news_kmp.feature.domain.repository.NewsRepository

class DeleteArticleUseCase(private val repo: NewsRepository) {
    suspend operator fun invoke(url: String) = repo.deleteArticle(url = url)
}
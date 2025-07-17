package com.aytachuseynli.news_kmp.feature.domain.usecase

import com.aytachuseynli.news_kmp.feature.domain.model.Article
import com.aytachuseynli.news_kmp.feature.domain.repository.NewsRepository

class SaveArticleUseCase(private val repo: NewsRepository) {
    suspend operator fun invoke(article: Article) = repo.saveArticle(article)
}
package com.aytachuseynli.news_kmp.feature.domain.usecase

import com.aytachuseynli.news_kmp.feature.domain.repository.NewsRepository

class IsSavedUseCase(private val repo: NewsRepository) {
    suspend operator fun invoke(url: String): Boolean = repo.isSaved(url)
}
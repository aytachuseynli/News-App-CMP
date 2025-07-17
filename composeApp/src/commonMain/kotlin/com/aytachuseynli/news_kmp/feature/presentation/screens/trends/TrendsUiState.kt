package com.aytachuseynli.news_kmp.feature.presentation.screens.trends

import com.aytachuseynli.news_kmp.core.presentation.HasErrorMessage
import com.aytachuseynli.news_kmp.core.presentation.HasLoading
import com.aytachuseynli.news_kmp.feature.domain.model.Article
import com.aytachuseynli.news_kmp.feature.domain.model.Trends

data class TrendsUiState(
    val articles: List<Article> = emptyList(),
    val trends: List<Trends> = emptyList(),
    val selectedCategory: String? = null,
    val categories: List<String> = emptyList(),
    override val isLoading: Boolean = false,
    override val errorMessage: String? = null
) : HasLoading, HasErrorMessage

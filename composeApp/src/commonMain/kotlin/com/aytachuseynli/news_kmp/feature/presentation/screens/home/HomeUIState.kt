package com.aytachuseynli.news_kmp.feature.presentation.screens.home

import com.aytachuseynli.news_kmp.core.presentation.HasErrorMessage
import com.aytachuseynli.news_kmp.core.presentation.HasLoading
import com.aytachuseynli.news_kmp.feature.domain.model.Article

data class HomeUiState(
    val articles: List<Article> = emptyList(),
    override val isLoading: Boolean = false,
    override val errorMessage: String? = null,
    val country: String = "us",
    val searchQuery: String = ""
) : HasLoading, HasErrorMessage

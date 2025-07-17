package com.aytachuseynli.news_kmp.feature.presentation.screens.favorites

import com.aytachuseynli.news_kmp.core.presentation.HasErrorMessage
import com.aytachuseynli.news_kmp.core.presentation.HasLoading
import com.aytachuseynli.news_kmp.feature.domain.model.Article

data class FavoritesUiState(
    val articles: List<Article> = emptyList(),
    val selectedCategory: String? = null,
    val categories: List<String> = emptyList(),
    val isSaved: Boolean = false,
    val savedStatus: Map<String, Boolean>  = emptyMap(),
    override val isLoading: Boolean = false,
    override val errorMessage: String? = null
) : HasLoading, HasErrorMessage

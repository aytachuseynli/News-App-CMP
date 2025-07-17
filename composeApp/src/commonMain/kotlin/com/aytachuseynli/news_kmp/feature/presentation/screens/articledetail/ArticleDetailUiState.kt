package com.aytachuseynli.news_kmp.feature.presentation.screens.articledetail

import com.aytachuseynli.news_kmp.core.presentation.HasErrorMessage
import com.aytachuseynli.news_kmp.core.presentation.HasLoading
import com.aytachuseynli.news_kmp.feature.domain.model.Article

data class ArticleDetailUiState(
    val article: Article? = null,
    val isSaved: Boolean = false,
    override val isLoading: Boolean = false,
    override val errorMessage: String? = null
) : HasLoading, HasErrorMessage
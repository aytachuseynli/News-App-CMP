package com.aytachuseynli.news_kmp.feature.presentation.screens.favorites

import com.aytachuseynli.news_kmp.core.presentation.BaseViewModel
import com.aytachuseynli.news_kmp.feature.domain.usecase.GetSavedArticlesUseCase

class FavoritesViewModel(
    private val getSavedArticles: GetSavedArticlesUseCase
) : BaseViewModel<FavoritesUiState>() {

    init {
        loadSavedArticles()
    }

    private fun loadSavedArticles() {
        collectHandled(
            onStart = {
                setState { copy(isLoading = true, errorMessage = null) }
            },
            flow = getSavedArticles(),
            onEach = { articles ->
                setState {
                    copy(
                        isLoading = false,
                        articles = articles,
                        errorMessage = null
                    )
                }
            },
            onError = { error ->
                setState {
                    copy(
                        isLoading = false,
                        errorMessage = error.message ?: "Unknown error occurred"
                    )
                }
            }
        )
    }

    override fun getInitialUiState() = FavoritesUiState(isLoading = true)

}

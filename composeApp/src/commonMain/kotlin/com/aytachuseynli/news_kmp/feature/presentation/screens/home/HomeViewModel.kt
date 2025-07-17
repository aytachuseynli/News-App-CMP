package com.aytachuseynli.news_kmp.feature.presentation.screens.home

import com.aytachuseynli.news_kmp.core.presentation.BaseViewModel
import com.aytachuseynli.news_kmp.feature.domain.model.Article
import com.aytachuseynli.news_kmp.feature.domain.usecase.GetTopHeadlinesUseCase
import com.aytachuseynli.news_kmp.feature.domain.usecase.SearchNewsUseCase

class HomeViewModel(
    private val topHeadlines: GetTopHeadlinesUseCase,
    private val searchNews: SearchNewsUseCase
) : BaseViewModel<HomeUiState>() {

    private var cachedHeadlines: List<Article> = emptyList()

    init { loadHeadlines(state.value.country) }

    fun loadHeadlines(country: String) = launchHandled(
        onStart = { setState { copy(isLoading = true, errorMessage = null, country = country) } },
        block = { topHeadlines(country) },
        onSuccess = { articles ->
            cachedHeadlines = articles
            setState { copy(articles = articles, isLoading = false, errorMessage = null) }
        },
        onError = { throwable ->
            setState { copy(isLoading = false, errorMessage = throwable.message.orEmpty()) }
        }
    )

    fun onSearchQueryChange(query: String) {
        setState { copy(
            articles = if (query.isBlank()) { cachedHeadlines } else { emptyList() },
            searchQuery = query
        ) }
    }

    fun search(query: String) {
        if (query.isBlank()) {
            setState { copy(articles = cachedHeadlines, searchQuery = "", isLoading = false) }
            return
        }

        launchHandled(
            onStart = { setState { copy(isLoading = true, errorMessage = null, searchQuery = query) } },
            block = { searchNews(query) },
            onSuccess = { articles ->
                setState { copy(articles = articles, isLoading = false, errorMessage = null) }
            },
            onError = { throwable ->
                setState { copy(isLoading = false, errorMessage = throwable.message.orEmpty()) }
            }
        )
    }

    override fun getInitialUiState(): HomeUiState = HomeUiState()
}

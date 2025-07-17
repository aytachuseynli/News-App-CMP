package com.aytachuseynli.news_kmp.feature.presentation.screens.trends

import com.aytachuseynli.news_kmp.core.presentation.BaseViewModel
import com.aytachuseynli.news_kmp.feature.domain.model.Trends
import com.aytachuseynli.news_kmp.feature.domain.usecase.TrendsSearchUseCase
import com.aytachuseynli.news_kmp.feature.domain.usecase.TrendsUseCase

class TrendsViewModel(
    private val trendsUseCase: TrendsUseCase,
    private val searchUseCase: TrendsSearchUseCase
) : BaseViewModel<TrendsUiState>() {

    init { loadAllSources() }

    private fun loadAllSources() = launchHandled(
        onStart  = { setState { copy(isLoading = true, errorMessage = null) } },
        block    = { trendsUseCase() },
        onSuccess = { sources -> updateStateWithSources(sources) },
        onError   = ::handleError
    )

    fun searchByCategory(category: String) = launchHandled(
        onStart  = { setState { copy(isLoading = true, selectedCategory = category) } },
        block    = { searchUseCase(category) },
        onSuccess = { sources -> updateStateWithSources(sources, category) },
        onError   = ::handleError
    )

    private fun updateStateWithSources(
        sources: List<Trends>,
        selectedCat: String? = null
    ) = setState {
        copy(
            trends = sources,
            categories =
                if (selectedCat == null)
                    sources.map { it.category }.distinct().sorted()
                else
                    categories,
            selectedCategory = selectedCat,
            isLoading        = false,
            errorMessage     = null
        )
    }

    private fun handleError(t: Throwable) = setState {
        copy(isLoading = false, errorMessage = t.message.orEmpty())
    }

    override fun getInitialUiState() = TrendsUiState()
}

package com.aytachuseynli.news_kmp.feature.presentation.screens.articledetail

import com.aytachuseynli.news_kmp.core.domain.NewsResult
import com.aytachuseynli.news_kmp.core.presentation.BaseViewModel
import com.aytachuseynli.news_kmp.feature.domain.model.Article
import com.aytachuseynli.news_kmp.feature.domain.usecase.DeleteArticleUseCase
import com.aytachuseynli.news_kmp.feature.domain.usecase.IsSavedUseCase
import com.aytachuseynli.news_kmp.feature.domain.usecase.SaveArticleUseCase

class ArticleDetailViewModel(
    private val isSavedUseCase: IsSavedUseCase,
    private val deleteArticle: DeleteArticleUseCase,
    private val saveArticle: SaveArticleUseCase
) : BaseViewModel<ArticleDetailUiState>() {
    fun setArticle(article: Article) {
        setState { copy(article = article) }
        checkIfSaved(article.url ?: "")
    }

    private fun checkIfSaved(url: String) {
        if (url.isBlank()) return

        launchHandled(
            block = { NewsResult.Success(isSavedUseCase(url)) },
            onSuccess = { isSaved ->
                setState { copy(isSaved = isSaved) }
            },
            onError = { error ->
                setState { copy(errorMessage = "Failed to check save status: ${error.message}") }
            }
        )
    }

    fun toggleSaveStatus() {
        val currentArticle = state.value.article ?: return
        val currentSaveStatus = state.value.isSaved
        if (state.value.isLoading) return

        if (currentSaveStatus) {
            deleteCurrentArticle(currentArticle)
        } else {
            saveCurrentArticle(currentArticle)
        }
    }

    private fun saveCurrentArticle(article: Article) {
        launchHandled(
            onStart = { setState { copy(isLoading = true) } },
            block = {
                saveArticle(article)
                NewsResult.Success(Unit)
            },
            onSuccess = {
                setState {
                    copy(
                        isSaved = true,
                        errorMessage = null,
                        isLoading = false
                    )
                }
            },
            onError = { error ->
                setState {
                    copy(
                        errorMessage = "Failed to save article: ${error.message}",
                        isLoading = false
                    )
                }
            }
        )
    }

    private fun deleteCurrentArticle(article: Article) {
        val url = article.url
        if (url.isNullOrBlank()) {
            setState { copy(errorMessage = "Cannot delete article: missing url") }
            return
        }

        launchHandled(
            onStart = { setState { copy(isLoading = true) } },
            block = {
                deleteArticle(url)
                NewsResult.Success(Unit)
            },
            onSuccess = {
                setState {
                    copy(
                        isSaved = false,
                        errorMessage = null,
                        isLoading = false
                    )
                }
            },
            onError = { error ->
                setState {
                    copy(
                        errorMessage = "Failed to delete article: ${error.message}",
                        isLoading = false
                    )
                }
            }
        )
    }

    fun clearError() {
        setState { copy(errorMessage = null) }
    }

    override fun getInitialUiState(): ArticleDetailUiState = ArticleDetailUiState()
}

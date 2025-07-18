package com.aytachuseynli.news_kmp.feature.presentation.screens.articledetail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.aytachuseynli.news_kmp.core.presentation.BaseScreen
import com.aytachuseynli.news_kmp.feature.domain.model.Article
import com.aytachuseynli.news_kmp.feature.presentation.screens.articledetail.components.ArticleDetailContent
import com.aytachuseynli.news_kmp.feature.presentation.screens.articledetail.components.ArticleDetailTopBar

@Composable
fun ArticleDetailRoute(
    article: Article,
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
) {
    BaseScreen<ArticleDetailUiState, ArticleDetailViewModel>(modifier = modifier) { uiState, viewModel ->

        LaunchedEffect(article) { viewModel.setArticle(article) }

        ArticleDetailScreen(
            modifier = modifier,
            uiState = uiState,
            onNavigateBack = onNavigateBack,
            onSave = viewModel::toggleSaveStatus,
            onClearError = viewModel::clearError
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ArticleDetailScreen(
    uiState: ArticleDetailUiState,
    onNavigateBack: () -> Unit,
    onSave: () -> Unit,
    onClearError: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(uiState.errorMessage) {
        uiState.errorMessage?.let { message ->
            snackbarHostState.showSnackbar(message)
            onClearError()
        }
    }

    Scaffold(
        topBar = {
            ArticleDetailTopBar(
                isSaved = uiState.isSaved,
                onNavigateBack = onNavigateBack,
                onSave = onSave
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        modifier = modifier.fillMaxWidth()
    ) { innerPadding ->

        ArticleDetailContent(
            article = uiState.article,
            isSaved = uiState.isSaved,
            modifier = Modifier
                .padding(top = innerPadding.calculateTopPadding())
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        )
    }
}

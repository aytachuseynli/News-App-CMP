package com.aytachuseynli.news_kmp.feature.presentation.screens.favorites

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aytachuseynli.news_kmp.core.presentation.BaseScreen
import com.aytachuseynli.news_kmp.feature.domain.model.Article
import com.aytachuseynli.news_kmp.feature.presentation.screens.home.components.NewsList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesRoute(
    modifier: Modifier = Modifier,
    onArticleClick: (Article) -> Unit = {}
) = BaseScreen<FavoritesUiState, FavoritesViewModel>(modifier = modifier) { uiState, viewModel ->
    FavoritesScreen(
        uiState = uiState,
        onArticleClick = onArticleClick,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FavoritesScreen(
    uiState: FavoritesUiState,
    onArticleClick: (Article) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {
        if (uiState.articles.isNotEmpty()) {
            NewsList(
                articles = uiState.articles,
                onItemClick = onArticleClick
            )
        } else if (!uiState.isLoading && uiState.errorMessage == null) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("No news found")
            }
        }
    }
}


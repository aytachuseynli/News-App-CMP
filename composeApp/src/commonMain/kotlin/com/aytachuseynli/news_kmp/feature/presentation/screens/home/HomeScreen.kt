package com.aytachuseynli.news_kmp.feature.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aytachuseynli.news_kmp.core.presentation.BaseScreen
import com.aytachuseynli.news_kmp.feature.domain.model.Article
import com.aytachuseynli.news_kmp.feature.presentation.screens.home.components.HomeContent
import com.aytachuseynli.news_kmp.feature.presentation.screens.home.components.SearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    onArticleClick: (Article) -> Unit = {}
) = BaseScreen<HomeUiState, HomeViewModel>(modifier = modifier) { uiState, viewModel ->

    HomeScreen(
        uiState = uiState,
        onSearchQueryChange = viewModel::onSearchQueryChange,
        onArticleClick = onArticleClick,
        onSearch = viewModel::search,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreen(
    uiState: HomeUiState,
    onSearchQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    onArticleClick: (Article) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {
        SearchBar(
            searchQuery = uiState.searchQuery,
            onSearchQueryChange = onSearchQueryChange,
            onSearch = onSearch,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        HomeContent(
            articles = uiState.articles,
            isLoading = uiState.isLoading,
            errorMessage = uiState.errorMessage,
            onArticleClick = onArticleClick
        )
    }
}
package com.aytachuseynli.news_kmp.navigation

import androidx.compose.runtime.Composable
import com.aytachuseynli.news_kmp.feature.presentation.screens.articledetail.ArticleDetailRoute
import com.aytachuseynli.news_kmp.feature.presentation.screens.favorites.FavoritesRoute
import com.aytachuseynli.news_kmp.feature.presentation.screens.home.HomeRoute
import com.aytachuseynli.news_kmp.feature.presentation.screens.trends.TrendsRoute

@Composable
fun NavigationManager(
    navigationState: NavigationState,
    modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier
) {
    when (val screen = navigationState.currentScreen) {
        Screen.Home -> HomeRoute(
            onArticleClick = navigationState::navigateToArticle,
            modifier = modifier
        )

        Screen.Trends -> TrendsRoute(
            modifier = modifier
        )

        Screen.Favorites -> FavoritesRoute(
            onArticleClick = navigationState::navigateToArticle,
            modifier = modifier
        )

        is Screen.ArticleDetail -> ArticleDetailRoute(
            article = screen.article,
            onNavigateBack = navigationState::navigateBack,
            modifier = modifier
        )
    }
}
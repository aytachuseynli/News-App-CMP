package com.aytachuseynli.news_kmp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Stable
import com.aytachuseynli.news_kmp.feature.domain.model.Article

@Stable
class NavigationState {
    var currentScreen by mutableStateOf<Screen>(Screen.Home)
        private set

    private val navigationStack = mutableListOf<Screen>(Screen.Home)

    fun navigateTo(screen: Screen) {
        if (currentScreen != screen) {
            currentScreen = screen
            navigationStack.add(screen)
        }
    }

    fun navigateBack(): Boolean {
        return if (navigationStack.size > 1) {
            navigationStack.removeLastOrNull()
            currentScreen = navigationStack.last()
            true
        } else {
            false
        }
    }

    fun navigateToArticle(article: Article) {
        navigateTo(Screen.ArticleDetail(article))
    }

    fun navigateToHome() {
        navigateTo(Screen.Home)
    }

    fun navigateToFavorites() {
        navigateTo(Screen.Favorites)
    }

    fun navigateToTrends() {
        navigateTo(Screen.Trends)
    }

    fun getCurrentBottomNavItem(): BottomNavItem {
        return when (currentScreen) {
            Screen.Home -> BottomNavItem.Home
            Screen.Favorites -> BottomNavItem.Favorites
            Screen.Trends -> BottomNavItem.Trends
            is Screen.ArticleDetail -> BottomNavItem.Home
        }
    }

    fun shouldShowBottomNav(): Boolean {
        return currentScreen !is Screen.ArticleDetail
    }
}

@Composable
fun rememberNavigationState(): NavigationState {
    return remember { NavigationState() }
}

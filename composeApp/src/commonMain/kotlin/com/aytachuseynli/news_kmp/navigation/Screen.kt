package com.aytachuseynli.news_kmp.navigation

import com.aytachuseynli.news_kmp.feature.domain.model.Article

sealed class Screen {
    object Home : Screen()
    object Favorites : Screen()
    object Trends : Screen()
    data class ArticleDetail(val article: Article) : Screen()
}

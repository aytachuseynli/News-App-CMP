package com.aytachuseynli.news_kmp.feature.domain.repository

import com.aytachuseynli.news_kmp.core.domain.NewsResult
import com.aytachuseynli.news_kmp.feature.domain.model.Article
import com.aytachuseynli.news_kmp.feature.domain.model.Trends
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    // API methods
    suspend fun headlines(country: String): NewsResult<List<Article>>

    suspend fun search(query: String): NewsResult<List<Article>>

    suspend fun trends(): NewsResult<List<Trends>>

    suspend fun trendsSearch(category: String): NewsResult<List<Trends>>

    // Database methods
    fun getSavedArticles(): Flow<List<Article>>
    suspend fun saveArticle(article: Article)
    suspend fun deleteArticle(url: String)
    suspend fun isSaved(url: String): Boolean
}

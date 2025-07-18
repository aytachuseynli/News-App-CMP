package com.aytachuseynli.news_kmp.feature.data.repository

import com.aytachuseynli.news_kmp.core.domain.NewsResult
import com.aytachuseynli.news_kmp.core.domain.map
import com.aytachuseynli.news_kmp.database.DatabaseHelper
import com.aytachuseynli.news_kmp.feature.data.dto.ArticleDto
import com.aytachuseynli.news_kmp.feature.data.dto.TrendsDto
import com.aytachuseynli.news_kmp.feature.data.mapper.toDomain
import com.aytachuseynli.news_kmp.feature.data.service.NewsApiClient
import com.aytachuseynli.news_kmp.feature.data.service.NewsApiService
import com.aytachuseynli.news_kmp.feature.domain.model.Article
import com.aytachuseynli.news_kmp.feature.domain.model.Trends
import com.aytachuseynli.news_kmp.feature.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val api: NewsApiClient,
    private val databaseHelper: DatabaseHelper
) : NewsRepository {
    // API methods
    override suspend fun headlines(country: String): NewsResult<List<Article>> =
        api.getTopHeadlines(country)
            .map { it.articles.map(ArticleDto::toDomain) }

    override suspend fun search(query: String): NewsResult<List<Article>> =
        api.searchEverything(query)
            .map { it.articles.map(ArticleDto::toDomain) }

    override suspend fun trends(): NewsResult<List<Trends>> =
        api.getSources()
            .map { it.sources.map(TrendsDto::toDomain) }

    override suspend fun trendsSearch(category: String): NewsResult<List<Trends>> =
        api.getSources(category = category)
            .map { it.sources.map(TrendsDto::toDomain) }

    // Database methods
    override fun getSavedArticles(): Flow<List<Article>> {
        return databaseHelper.getAllArticlesFlow()
    }

    override suspend fun saveArticle(article: Article) {
        databaseHelper.insertOrReplaceArticle(article)
    }

    override suspend fun deleteArticle(url: String) {
        databaseHelper.deleteArticleByUrl(url)
    }

    override suspend fun isSaved(url: String): Boolean {
        return databaseHelper.getArticleByUrl(url) != null
    }
}



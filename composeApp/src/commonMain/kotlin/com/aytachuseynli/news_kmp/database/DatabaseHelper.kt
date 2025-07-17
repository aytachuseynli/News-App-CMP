package com.aytachuseynli.news_kmp.database

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.aytachuseynli.news_kmp.feature.data.mapper.toDomainModel
import com.aytachuseynli.news_kmp.feature.domain.model.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class DatabaseHelper(private val database: NewsDatabase) {

    private val queries = database.newsDatabaseQueries

    suspend fun insertOrReplaceArticle(article: Article) {
        withContext(Dispatchers.IO) {
            queries.insertOrReplaceArticle(
                source_id = article.source.id,
                source_name = article.source.name,
                url = article.url ?: "",
                author = article.author,
                title = article.title,
                description = article.description,
                image_url = article.imageUrl,
                published_at = article.published
            )
        }
    }

    fun getAllArticlesFlow(): Flow<List<Article>> {
        return queries.getAllArticles()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map { dbArticles ->
                dbArticles.map { it.toDomainModel() }
            }
    }

    suspend fun getArticleByUrl(url: String): Article? {
        return withContext(Dispatchers.IO) {
            queries.getArticleByUrl(url).executeAsOneOrNull()?.toDomainModel()
        }
    }
    suspend fun deleteArticleByUrl(url: String) {
        withContext(Dispatchers.IO) {
            queries.deleteArticleByUrl(url)
        }
    }

    suspend fun deleteArticlesBySourceId(sourceId: String) {
        withContext(Dispatchers.IO) {
            queries.deleteArticlesBySourceId(sourceId)
        }
    }
}
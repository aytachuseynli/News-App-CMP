package com.aytachuseynli.news_kmp.feature.data.mapper

import com.aytachuseynli.news_kmp.feature.data.dto.ArticleDto
import com.aytachuseynli.news_kmp.feature.data.dto.SourceDto
import com.aytachuseynli.news_kmp.feature.domain.model.Article
import com.aytachuseynli.news_kmp.feature.domain.model.Source

fun SourceDto.toDomain() = Source(
    id = id,
    name = name
)

fun ArticleDto.toDomain() = Article(
    author = author,
    title = title,
    description = description,
    url = url,
    imageUrl = imageUrl,
    published = published,
    source = source.toDomain()
)

fun com.aytachuseynli.newskmp.feature.data.sqldelight.Article.toDomainModel(): Article {
    return Article(
        author = this.author,
        title = this.title,
        description = this.description,
        url = this.url,
        imageUrl = this.image_url,
        published = this.published_at,
        source = Source(
            id = this.source_id,
            name = this.source_name
        )
    )
}
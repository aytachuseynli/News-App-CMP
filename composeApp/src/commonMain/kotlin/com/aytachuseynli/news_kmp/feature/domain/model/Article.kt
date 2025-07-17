package com.aytachuseynli.news_kmp.feature.domain.model

data class Article(
    val author: String? = null,
    val title: String? = null,
    val description: String? = null,
    val url: String? = null,
    val imageUrl: String? = null,
    val published: String? = null,
    val source: Source
)
data class Source(
    val id: String? = null,
    val name: String? = null
)

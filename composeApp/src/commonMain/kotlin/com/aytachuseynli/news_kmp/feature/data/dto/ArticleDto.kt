package com.aytachuseynli.news_kmp.feature.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleDto(
    @SerialName("author") val author: String? = null,
    @SerialName("title") val title: String? = null,
    @SerialName("description") val description: String? = null,
    @SerialName("url") val url: String? = null,
    @SerialName("urlToImage") val imageUrl: String? = null,
    @SerialName("publishedAt") val published: String? = null,
    @SerialName("source") val source: SourceDto,
    @SerialName("content") val content: String? = null
)

@Serializable
data class SourceDto(
    @SerialName("id") val id: String? = null,
    @SerialName("name") val name: String? = null
)

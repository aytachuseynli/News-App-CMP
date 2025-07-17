package com.aytachuseynli.news_kmp.feature.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrendsResponseDto(
    @SerialName("status") val status: String,
    @SerialName("sources") val sources: List<TrendsDto>
)

@Serializable
data class TrendsDto(
    val id: String? = null,
    val name: String,
    val description: String,
    val url: String,
    val category: String,
    val language: String,
    val country: String
)

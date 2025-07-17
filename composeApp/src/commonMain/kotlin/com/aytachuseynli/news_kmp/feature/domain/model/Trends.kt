package com.aytachuseynli.news_kmp.feature.domain.model

data class Trends(
    val id: String?,
    val name: String,
    val description: String,
    val url: String,
    val category: String,
    val language: String,
    val country: String
)
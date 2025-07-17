package com.aytachuseynli.news_kmp.feature.data.mapper

import com.aytachuseynli.news_kmp.feature.data.dto.TrendsDto
import com.aytachuseynli.news_kmp.feature.domain.model.Trends

fun TrendsDto.toDomain() = Trends(
    id = id,
    name = name,
    description = description,
    url = url,
    category = category,
    language = language,
    country = country
)

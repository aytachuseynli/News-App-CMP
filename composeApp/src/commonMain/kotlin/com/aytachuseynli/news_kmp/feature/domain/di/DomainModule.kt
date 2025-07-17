package com.aytachuseynli.news_kmp.feature.domain.di

import com.aytachuseynli.news_kmp.feature.domain.usecase.DeleteArticleUseCase
import com.aytachuseynli.news_kmp.feature.domain.usecase.GetSavedArticlesUseCase
import com.aytachuseynli.news_kmp.feature.domain.usecase.GetTopHeadlinesUseCase
import com.aytachuseynli.news_kmp.feature.domain.usecase.IsSavedUseCase
import com.aytachuseynli.news_kmp.feature.domain.usecase.SaveArticleUseCase
import com.aytachuseynli.news_kmp.feature.domain.usecase.SearchNewsUseCase
import com.aytachuseynli.news_kmp.feature.domain.usecase.TrendsSearchUseCase
import com.aytachuseynli.news_kmp.feature.domain.usecase.TrendsUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetTopHeadlinesUseCase)
    factoryOf(::SearchNewsUseCase)
    factoryOf(::TrendsUseCase)
    factoryOf(::TrendsSearchUseCase)
    factoryOf(::GetSavedArticlesUseCase)
    factoryOf(::SaveArticleUseCase)
    factoryOf(::DeleteArticleUseCase)
    factoryOf(::IsSavedUseCase)
}
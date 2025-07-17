package com.aytachuseynli.news_kmp.feature.data.di

import com.aytachuseynli.news_kmp.database.DatabaseHelper
import com.aytachuseynli.news_kmp.database.createDatabase
import com.aytachuseynli.news_kmp.feature.data.repository.NewsRepositoryImpl
import com.aytachuseynli.news_kmp.feature.data.service.NewsApiClient
import com.aytachuseynli.news_kmp.feature.data.service.NewsApiService
import com.aytachuseynli.news_kmp.feature.domain.repository.NewsRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    singleOf(::NewsApiService) { bind<NewsApiClient>() }
    singleOf(::createDatabase)
    singleOf(::DatabaseHelper)
    single<NewsRepository> {
        NewsRepositoryImpl(
            api = get(),
            databaseHelper = get()
        )
    }
}

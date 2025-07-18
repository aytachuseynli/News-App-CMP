package com.aytachuseynli.news_kmp.feature.presentation.di

import com.aytachuseynli.news_kmp.feature.presentation.screens.articledetail.ArticleDetailViewModel
import com.aytachuseynli.news_kmp.feature.presentation.screens.favorites.FavoritesViewModel
import com.aytachuseynli.news_kmp.feature.presentation.screens.home.HomeViewModel
import com.aytachuseynli.news_kmp.feature.presentation.screens.trends.TrendsViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    singleOf(::HomeViewModel)
    viewModelOf(::ArticleDetailViewModel)

    singleOf(::TrendsViewModel)
    singleOf(::FavoritesViewModel)
}

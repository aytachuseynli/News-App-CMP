package com.aytachuseynli.news_kmp.di

import com.aytachuseynli.news_kmp.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
}

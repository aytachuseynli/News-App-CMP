package com.aytachuseynli.news_kmp.di

import com.aytachuseynli.news_kmp.feature.data.di.dataModule
import com.aytachuseynli.news_kmp.feature.domain.di.domainModule
import com.aytachuseynli.news_kmp.feature.presentation.di.presentationModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            sharedModule,
            platformModule,
            domainModule,
            presentationModule,
            dataModule
        )
    }
}
package com.aytachuseynli.news_kmp

import android.app.Application
import com.aytachuseynli.news_kmp.database.initializeDatabase
import com.aytachuseynli.news_kmp.di.initKoin
import org.koin.android.ext.koin.androidContext

class NewsApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        initializeDatabase(this)

        initKoin {
            androidContext(this@NewsApplication)
        }
    }
    companion object {
        lateinit var instance: NewsApplication
            private set
    }
}

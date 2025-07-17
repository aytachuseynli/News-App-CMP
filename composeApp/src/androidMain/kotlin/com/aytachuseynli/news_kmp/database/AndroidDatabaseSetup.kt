package com.aytachuseynli.news_kmp.database

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
private lateinit var appContext: Context

fun initializeDatabase(context: Context) {
    appContext = context.applicationContext
}

actual fun createDatabaseDriver(): SqlDriver {
    return AndroidSqliteDriver(
        schema = NewsDatabase.Schema,
        context = appContext,
        name = "news_database.db"
    )
}

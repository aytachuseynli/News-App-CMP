package com.aytachuseynli.news_kmp.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

actual fun createDatabaseDriver(): SqlDriver {
    return NativeSqliteDriver(
        schema = NewsDatabase.Schema,
        name = "news_database.db"
    )
}
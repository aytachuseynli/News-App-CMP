package com.aytachuseynli.news_kmp.database

import app.cash.sqldelight.db.SqlDriver

expect fun createDatabaseDriver(): SqlDriver
fun createDatabase(): NewsDatabase {
    val driver = createDatabaseDriver()
    return NewsDatabase.Companion(driver)
}
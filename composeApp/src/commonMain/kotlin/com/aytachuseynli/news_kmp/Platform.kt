package com.aytachuseynli.news_kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
package com.aytachuseynli.news_kmp.core.domain

class ApiException(val code: Int?, override val message: String?) : Exception(message)

package com.aytachuseynli.news_kmp.feature.presentation.screens.home.util

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.Padding
import kotlinx.datetime.format.char
import kotlinx.datetime.toLocalDateTime
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
fun String?.formatAsDate(): String = this?.let {
    Instant.parse(it).toLocalDateTime(TimeZone.currentSystemDefault())
        .format(LocalDateTime.Format {
            monthName(MonthNames.ENGLISH_ABBREVIATED)
            char(' ')
            day(padding = Padding.ZERO)
            chars(", ")
            year()
        })
} ?: ""
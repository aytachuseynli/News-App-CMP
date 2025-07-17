package com.aytachuseynli.news_kmp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Stream
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNavItem(
    val title: String,
    val icon: ImageVector
) {
    Home("Home", Icons.Default.Home),
    Favorites("Favorites", Icons.Default.Favorite),
    Trends("Trends", Icons.Default.TrendingUp);

    companion object {
        fun values(): Array<BottomNavItem> = arrayOf(Home, Favorites, Trends)
    }
}
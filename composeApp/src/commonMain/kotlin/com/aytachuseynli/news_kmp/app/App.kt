package com.aytachuseynli.news_kmp.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.aytachuseynli.news_kmp.navigation.BottomNavItem
import com.aytachuseynli.news_kmp.navigation.BottomNavigationBar
import com.aytachuseynli.news_kmp.navigation.NavigationManager
import com.aytachuseynli.news_kmp.navigation.rememberNavigationState
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navigationState = rememberNavigationState()

        Scaffold(
            bottomBar = {
                if (navigationState.shouldShowBottomNav()) {
                    BottomNavigationBar(
                        current = navigationState.getCurrentBottomNavItem(),
                        onTabSelected = { item ->
                            when (item) {
                                BottomNavItem.Home -> navigationState.navigateToHome()
                                BottomNavItem.Favorites -> navigationState.navigateToFavorites()
                                BottomNavItem.Trends -> navigationState.navigateToTrends()
                            }
                        }
                    )
                }
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                NavigationManager(navigationState = navigationState)
            }
        }
    }
}

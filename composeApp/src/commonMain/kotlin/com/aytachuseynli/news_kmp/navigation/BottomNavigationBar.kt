package com.aytachuseynli.news_kmp.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BottomNavigationBar(
    current: BottomNavItem,
    onTabSelected: (BottomNavItem) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        BottomNavItem.entries.forEach { item ->
            NavigationBarItem(
                selected = current == item,
                onClick = { onTabSelected(item) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) }
            )
        }
    }
}

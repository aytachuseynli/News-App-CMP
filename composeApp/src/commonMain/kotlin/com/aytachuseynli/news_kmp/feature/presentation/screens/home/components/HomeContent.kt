package com.aytachuseynli.news_kmp.feature.presentation.screens.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aytachuseynli.news_kmp.feature.domain.model.Article

@Composable
fun HomeContent(
    articles: List<Article>,
    isLoading: Boolean,
    errorMessage: String?,
    onArticleClick: (Article) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        if (articles.isNotEmpty()) {
            SlideableNewsContent(
                articles = articles,
                onArticleClick = onArticleClick,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Top reads of the day",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(16.dp))

            NewsList(
                articles = articles,
                onItemClick = onArticleClick
            )
        } else if (!isLoading && errorMessage == null) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("No news found")
            }
        }
    }
}

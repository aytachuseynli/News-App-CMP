package com.aytachuseynli.news_kmp.feature.presentation.screens.articledetail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.aytachuseynli.news_kmp.feature.domain.model.Article

@Composable
fun ArticleDetailContent(
    article: Article?,
    isSaved: Boolean,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        AsyncImage(
            model = article?.imageUrl,
            contentDescription = article?.title,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .height(200.dp)
                .fillMaxWidth(),
            contentScale = androidx.compose.ui.layout.ContentScale.Crop
        )

        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Text(
                text = article?.title.orEmpty(),
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = buildString {
                    article?.source?.name?.let { sourceName ->
                        append(sourceName)
                        article.author?.let { author ->
                            append(" • $author")
                        }
                    }
                },
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(Modifier.height(16.dp))

            Text(
                text = article?.description.orEmpty(),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Start
            )

            Spacer(Modifier.height(16.dp))

            if (isSaved) {
                Text(
                    text = "✓ Saved to favorites",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}
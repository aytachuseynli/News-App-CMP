package com.aytachuseynli.news_kmp.feature.presentation.screens.trends


import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aytachuseynli.news_kmp.core.presentation.BaseScreen
import com.aytachuseynli.news_kmp.feature.domain.model.Trends
import com.aytachuseynli.news_kmp.feature.presentation.screens.trends.components.CategoryCard
import com.aytachuseynli.news_kmp.feature.presentation.screens.trends.components.TrendSourceCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrendsRoute(
    modifier: Modifier = Modifier,
) = BaseScreen<TrendsUiState, TrendsViewModel>(modifier = modifier) { uiState, viewModel ->
    TrendsScreen(
        uiState = uiState,
        onCategorySelected = viewModel::searchByCategory,
        onSourceClick = {},
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TrendsScreen(
    uiState: TrendsUiState,
    onCategorySelected: (String) -> Unit,
    onSourceClick: (Trends) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            modifier = Modifier.padding(bottom = 8.dp),
            text = "Walk with Trend",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            modifier = Modifier.padding(bottom = 8.dp),
            text = "Don't stay behind, read the trend",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            uiState.categories.forEach { cat ->
                CategoryCard(
                    category = cat,
                    isSelected = cat == uiState.selectedCategory,
                    onClick = { onCategorySelected(cat) }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        AnimatedContent(
            targetState = uiState.selectedCategory,
            transitionSpec = { fadeIn() togetherWith fadeOut() }
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(uiState.trends) { source ->
                    TrendSourceCard(
                        source = source,
                        onSourceClick = onSourceClick
                    )
                }
                item { Spacer(Modifier.height(16.dp)) }
            }
        }
    }
}

package com.aytachuseynli.news_kmp.core.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.koinInject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
inline fun <UiState, reified VM : BaseViewModel<UiState>> BaseScreen(
    modifier: Modifier = Modifier,
    viewModel: VM = koinInject(),
    crossinline content: @Composable (uiState: UiState, viewModel: VM) -> Unit
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()

    Box(modifier = Modifier.fillMaxSize()) {
        val isLoading = (uiState as? HasLoading)?.isLoading == true
        if (isLoading) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        } else {
            content(uiState, viewModel)
        }

        val errorMsg = (uiState as? HasErrorMessage)?.errorMessage
        if (!errorMsg.isNullOrBlank()) {
            Snackbar(Modifier.align(Alignment.BottomCenter)) { Text(errorMsg) }
        }
    }
}
interface HasLoading { val isLoading: Boolean }
interface HasErrorMessage { val errorMessage: String? }

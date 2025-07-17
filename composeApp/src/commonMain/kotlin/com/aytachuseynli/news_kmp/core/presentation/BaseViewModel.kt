package com.aytachuseynli.news_kmp.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aytachuseynli.news_kmp.core.domain.NewsResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseViewModel<S>(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _state = MutableStateFlow(getInitialUiState())
    val state: StateFlow<S> = _state.asStateFlow()

    /** Abstract method subclasses must implement to provide initial UI state */
    abstract fun getInitialUiState(): S

    /** Atomically update state using a reducer. */
    protected fun setState(reducer: S.() -> S) {
        _state.update(reducer)
    }

    /**
     * Launch suspending [block] in [viewModelScope] and handle [NewsResult]
     * with the provided callbacks.
     */
    protected fun <T> launchHandled(
        onStart: () -> Unit = {},
        block: suspend () -> NewsResult<T>,
        onSuccess: (T) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        viewModelScope.launch(dispatcher) {
            onStart()
            when (val result = block()) {
                is NewsResult.Success -> onSuccess(result.data)
                is NewsResult.Error -> onError(result.error)
            }
        }
    }

    protected fun <T> collectHandled(
        onStart: () -> Unit = {},
        flow: Flow<T>,
        onEach: (T) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        viewModelScope.launch(dispatcher) {
            onStart()
            flow.catch { onError(it) }.collect(onEach)
        }
    }
}

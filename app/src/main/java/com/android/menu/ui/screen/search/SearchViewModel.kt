package com.android.menu.screen.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.menu.domain.usecase.GetAllFoodList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getAllFoodList: GetAllFoodList
) : ViewModel() {

    private val _viewState = MutableStateFlow(SearchUiState())
    val viewState: StateFlow<SearchUiState> = _viewState.asStateFlow()

    init {
        viewModelScope.launch {
            getAllFoodList()
                .catch { cause -> _viewState.update {
                    cause.printStackTrace()
                    it.copy(error = true) }
                }
                .collect { allFoodList -> _viewState.update { _viewState.value.copy(allFoodList = allFoodList) } }
        }
    }
}
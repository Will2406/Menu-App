package com.yape.menu.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yape.menu.domain.GetCategoryList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCategoryList: GetCategoryList
) : ViewModel() {

    private val _viewState = MutableStateFlow(HomeUiState())
    val viewState: StateFlow<HomeUiState> = _viewState.asStateFlow()


    init {
        viewModelScope.launch {
            getCategoryList()
                .catch { cause -> _viewState.update { it.copy(error = true) } }
                .collect { categoryList -> _viewState.update { HomeUiState(categoryList = categoryList) } }
        }
    }


}
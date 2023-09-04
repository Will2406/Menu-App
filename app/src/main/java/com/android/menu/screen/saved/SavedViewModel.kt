package com.android.menu.screen.saved

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.menu.domain.usecase.GetAllStoredFoodList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SavedViewModel @Inject constructor(
    private val getAllStoredFoodList: GetAllStoredFoodList
) : ViewModel() {

    private val _viewState = MutableStateFlow(SavedUiState())
    val viewState: StateFlow<SavedUiState> = _viewState.asStateFlow()


    fun getAllStoredFood() {
        viewModelScope.launch(Dispatchers.IO) {
            getAllStoredFoodList()
                .collect { categoryList ->
                    _viewState.update { it.copy(allFoodList = categoryList) }
                }
        }
    }
}
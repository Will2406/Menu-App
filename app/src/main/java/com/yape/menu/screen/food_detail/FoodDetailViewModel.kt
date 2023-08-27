package com.yape.menu.screen.food_detail

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yape.menu.domain.TrendingFoodModel
import com.yape.menu.fromJson
import com.yape.menu.screen.home.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _viewState = MutableStateFlow(FoodDetailUiState())
    val viewState: StateFlow<FoodDetailUiState> = _viewState.asStateFlow()

    init {
        viewModelScope.launch {
            val argument = Uri.decode(savedStateHandle.get<String>("food").orEmpty())
            val food = argument.fromJson<TrendingFoodModel>()
            _viewState.update {_viewState.value.copy(trendingFood = food)}
        }
    }
}
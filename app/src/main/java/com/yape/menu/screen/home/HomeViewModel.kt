package com.yape.menu.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yape.menu.domain.usecase.GetCategoryList
import com.yape.menu.domain.usecase.GetFoodTrendingList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCategoryList: GetCategoryList,
    private val getFoodTrendingList: GetFoodTrendingList
) : ViewModel() {

    private val _viewState = MutableStateFlow(HomeUiState())
    val viewState: StateFlow<HomeUiState> = _viewState.asStateFlow()


    init {
        viewModelScope.launch {
            _viewState.update { it.copy(isCategoryLoading = true, isFoodTrendingLoading = true) }
            delay(3000)
            getCategoryList()
                .catch { cause ->
                    _viewState.update { it.copy(error = true) }
                }
                .collect { categoryList ->
                    _viewState.update { it.copy(categoryList = categoryList, isCategoryLoading = false) }
                }

            getFoodTrendingList()
                .catch { cause ->
                    _viewState.update { it.copy(error = true) }
                }
                .collect { foodTrendingList ->
                    _viewState.update { it.copy(foodTrendingList = foodTrendingList, isFoodTrendingLoading = false) }
                }
        }
    }


}
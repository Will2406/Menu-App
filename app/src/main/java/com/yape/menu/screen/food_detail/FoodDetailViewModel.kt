package com.yape.menu.screen.food_detail

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yape.domain.core.fromJson
import com.yape.domain.model.FoodModel
import com.yape.domain.usecase.CheckIfFoodIsSaved
import com.yape.domain.usecase.DeleteFoodStored
import com.yape.domain.usecase.SaveFoodInStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val saveFood: SaveFoodInStorage,
    private val deleteFood: DeleteFoodStored,
    private val checkIfFoodIsSaved: CheckIfFoodIsSaved
) : ViewModel() {

    private val _viewState = MutableStateFlow(FoodDetailUiState())
    val viewState: StateFlow<FoodDetailUiState> = _viewState.asStateFlow()


    fun getFoodDetail() {
        viewModelScope.launch(Dispatchers.IO) {
            val argument = Uri.decode(savedStateHandle.get<String>("food").orEmpty())
            val food = argument.fromJson<FoodModel>()

            checkIfFoodIsSaved.invoke(food?.id.orEmpty())
                .collect { isFoodSaved ->
                    _viewState.update {
                        val foodUpdated = food?.copy(isSaved = isFoodSaved)
                        _viewState.value.copy(food = foodUpdated)
                    }
                }

        }
    }

    fun saveFoodInLocalStorage(food: FoodModel) {
        viewModelScope.launch(Dispatchers.IO) {
            _viewState.update {  _viewState.value.copy(food = food)}
            saveFood.invoke(food)
        }
    }

    fun deleteFoodInLocalStorage(food: FoodModel) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteFood.invoke(food)
        }
    }
}
package com.android.menu.screen.saved

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import com.android.menu.FoodMainItem
import com.android.menu.domain.core.toJson
import com.android.menu.navigation.main.MainRoute
import kotlinx.coroutines.flow.StateFlow


@Composable
fun InitSavedScreen(navHostController: NavHostController) {
    val savedViewModel: SavedViewModel = hiltViewModel()
    SavedScreen(
        navHostController = navHostController,
        viewModel = savedViewModel,
        state = savedViewModel.viewState
    )
}

@Composable
private fun SavedScreen(navHostController: NavHostController, viewModel: SavedViewModel, state: StateFlow<SavedUiState>) {

    val state = state.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.getAllStoredFood()
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        val itemSize: Dp = (LocalConfiguration.current.screenWidthDp.dp / 2) - 12.dp
        Text(
            text = "Saved",
            style = MaterialTheme.typography.titleSmall,
            fontSize = 30.sp,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
        )
        FlowRow(
            mainAxisSize = SizeMode.Expand,
            mainAxisSpacing = 8.dp,
            mainAxisAlignment = FlowMainAxisAlignment.SpaceBetween,
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            state.allFoodList.forEach {
                FoodMainItem(
                    modifier = Modifier
                        .width(itemSize)
                        .clickable {
                            navHostController.navigate(MainRoute.FoodDetailScreen.createRoot(it.toJson()))
                        },
                    foodTrending = it
                )
            }
        }
    }
}
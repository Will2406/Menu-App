package com.yape.menu.screen.saved

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import com.yape.domain.core.toJson
import com.yape.menu.CategoryMainItem
import com.yape.menu.FoodMainItem
import com.yape.menu.navigation.BottomBarNav
import com.yape.menu.screen.home.HomeUiState
import com.yape.menu.screen.home.TitleSection
import com.yape.menu.screen.search.SearchScreen
import com.yape.menu.screen.search.SearchViewModel
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
                            navHostController.navigate(BottomBarNav.FoodDetailScreen.createRoot(it.toJson()))
                        },
                    foodTrending = it
                )
            }
        }
    }
}
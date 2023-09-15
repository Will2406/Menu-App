package com.android.menu.screen.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.android.menu.FoodMainItem
import com.android.menu.domain.core.toJson
import com.android.menu.navigation.BottomBarNav
import kotlinx.coroutines.flow.StateFlow


@Composable
fun InitSearchScreen(navHostController: NavHostController) {
    val searchViewModel: SearchViewModel = hiltViewModel()
    SearchScreen(navHostController = navHostController, state = searchViewModel.viewState)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navHostController: NavHostController, state: StateFlow<SearchUiState>) {
    val state = state.collectAsState().value
    var text by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        SearchBar(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 16.dp),
            query = text,
            onQueryChange = { text = it },
            onSearch = { active = false },
            active = active,
            onActiveChange = {
                active = it
            },
            placeholder = { Text("Search food, drinks, etc ") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            trailingIcon = { Icon(Icons.Default.MoreVert, contentDescription = null) },
        ) {
            if (text.isNotEmpty()) {
                val foodFiltered = state.allFoodList.filter { it.name.lowercase().contains(text.lowercase()) }

                LazyColumn(
                    contentPadding = PaddingValues(start = 16.dp, top = 72.dp, end = 16.dp, bottom = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    foodFiltered.forEach {
                        item {
                            FoodMainItem(
                                foodTrending = it,
                                modifier = Modifier.clickable {
                                    navHostController.navigate(
                                        BottomBarNav.FoodDetailScreen.createRoot(it.toJson())
                                    )
                                }
                            )
                        }
                    }
                }
            }

        }
        LazyColumn(
            contentPadding = PaddingValues(start = 16.dp, top = 72.dp, end = 16.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            state.allFoodList.forEach {
                item {
                    FoodMainItem(
                        foodTrending = it,
                        modifier = Modifier.clickable {
                            navHostController.navigate(
                                BottomBarNav.FoodDetailScreen.createRoot(it.toJson())
                            )
                        })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    MaterialTheme {
        //SearchScreen()
    }
}
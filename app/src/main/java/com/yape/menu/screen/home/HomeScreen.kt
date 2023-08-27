package com.yape.menu.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import com.yape.menu.CategoryMainItem
import com.yape.menu.FoodMainItem
import com.yape.menu.data.CategoryModel
import com.yape.menu.navigation.BottomBarNav
import kotlinx.coroutines.flow.StateFlow

@Composable
fun InitHomeScreen(navHostController: NavHostController) {
    val homeViewModel: HomeViewModel = hiltViewModel()
    HomeScreen(navHostController = navHostController, state = homeViewModel.viewState)
}

@Composable
private fun HomeScreen(navHostController: NavHostController, state: StateFlow<HomeUiState>) {
    val state = state.collectAsState().value
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Text(
                text = "Welcome,\nDaniel Quispe",
                fontSize = 20.sp,
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(16.dp)
            )
        }
        when {
            state.loading -> {}
            else -> {
                if (state.categoryList.isNotEmpty()) {
                    item { CategorySection(state.categoryList) }
                }
            }
        }


        item { FoodSection(navHostController) }

    }
}

@Composable
private fun FoodSection(navHostController: NavHostController) {

    TitleSection(
        title = "Trending Now",
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {}

    val itemSize: Dp = (LocalConfiguration.current.screenWidthDp.dp / 2) - 12.dp

    FlowRow(
        mainAxisSize = SizeMode.Expand,
        mainAxisSpacing = 8.dp,
        mainAxisAlignment = FlowMainAxisAlignment.SpaceBetween,
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        for (i in 1..10) {
            FoodMainItem(modifier = Modifier
                .width(itemSize)
                .clickable {
                    navHostController.navigate(BottomBarNav.FoodDetailScreen.route)
                })
        }
    }

}


@Composable
private fun CategorySection(categoryList: List<CategoryModel>) {
    Column {
        TitleSection(
            title = "Browse by Category",
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {}

        LazyRow(
            contentPadding = PaddingValues(start = 4.dp, end = 16.dp),
        ) {
            categoryList.forEach {
                item {
                    CategoryMainItem(
                        imageUrl = it.image,
                        title = it.name
                    )
                }
            }

        }
    }
}

@Composable
fun TitleSection(modifier: Modifier = Modifier, title: String, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.Bottom,
        modifier = modifier
            .fillMaxWidth()
            .height(36.dp)
    ) {

        Text(
            text = title,
            fontSize = 24.sp,
            style = MaterialTheme.typography.titleSmall
        )
        Spacer(modifier = Modifier.weight(1.0f))

        Box(
            modifier = Modifier
                .background(
                    color = Color(0xFFF1F2EE),
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Text(
                text = "View All",
                fontSize = 16.sp,
                color = Color(0xFF7B8264),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.clickable {
                    onClick.invoke()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        // HomeScreen(navHostController = rememberNavController())
    }
}
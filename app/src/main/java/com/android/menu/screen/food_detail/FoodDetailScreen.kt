package com.android.menu.screen.food_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import com.android.menu.FoodIngredient
import com.android.menu.FoodItemAttribute
import com.android.menu.HeaderComponent
import com.android.menu.OrientationType
import com.android.menu.domain.model.FoodModel
import com.android.menu.domain.model.IngredientModel
import com.android.menu.navigation.BottomBarNav
import com.android.menu.ui.theme.gray50Percent
import com.android.menu.ui.theme.transparent
import com.android.menu.R
import kotlinx.coroutines.flow.StateFlow


@Composable
fun InitFoodDetailScreen(navHostController: NavHostController) {
    val foodDetailViewModel: FoodDetailViewModel = hiltViewModel()
    FoodDetailScreen(
        navHostController = navHostController,
        viewModel = foodDetailViewModel,
        state = foodDetailViewModel.viewState
    )
}

@Composable
private fun FoodDetailScreen(
    navHostController: NavHostController,
    viewModel: FoodDetailViewModel,
    state: StateFlow<FoodDetailUiState>
) {

    val state = state.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.getFoodDetail()
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        when {
            state.food != null -> {
                item {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(360.dp)
                    ) {
                        HeaderComponent(
                            modifier = Modifier.zIndex(2f),
                            title = "Details",
                            isSaved = state.food.isSaved,
                            onBackPressed = { navHostController.popBackStack() },
                            onSavePressed = { stateMarked ->
                                val food = state.food.copy(isSaved = stateMarked)
                                if (stateMarked) {
                                    viewModel.saveFoodInLocalStorage(food)
                                } else {
                                    viewModel.deleteFoodInLocalStorage(food)
                                }
                            }
                        )

                        Image(
                            painter = rememberAsyncImagePainter(
                                state.food.image
                            ),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .zIndex(0f)
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .zIndex(1f)
                                .background(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(gray50Percent, transparent)
                                    )
                                )
                        )
                    }
                }

                item { FoodDescription(trendingFood = state.food) }

                item { FoodIngredientList(ingredientList = state.food.ingredientList) }
            }
        }


        item {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                onClick = { navHostController.navigate(BottomBarNav.FoodMapScreen.route) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7B8264))
            ) {
                Text(
                    text = "Go to Restaurant",
                    color = Color.White,
                    style = MaterialTheme.typography.displayMedium
                )
            }
        }
    }
}


@Composable
fun FoodDescription(modifier: Modifier = Modifier, trendingFood: FoodModel) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row {
            Text(
                text = trendingFood.name,
                style = MaterialTheme.typography.titleSmall,
                fontSize = 22.sp,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.width(200.dp),
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = trendingFood.price,
                style = MaterialTheme.typography.titleSmall,
                fontSize = 22.sp
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
        ) {
            FoodItemAttribute(
                modifier = Modifier
                    .weight(1f),
                icon = R.drawable.ic_rate,
                description = "${trendingFood.rating} Rating",
                type = OrientationType.VERTICAL
            )
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .height(18.dp)
                    .width(1.dp)
            )
            FoodItemAttribute(
                modifier = Modifier
                    .weight(1f),
                icon = R.drawable.ic_comment,
                description = trendingFood.reviewers,
                type = OrientationType.VERTICAL
            )
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .height(18.dp)
                    .width(1.dp)

            )
            FoodItemAttribute(
                modifier = Modifier
                    .weight(1f),
                icon = R.drawable.ic_calories,
                description = trendingFood.calories,
                type = OrientationType.VERTICAL
            )
        }

        Text(
            text = trendingFood.description,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.bodySmall,
            fontSize = 14.sp
        )
    }
}

@Composable
fun FoodIngredientList(ingredientList: List<IngredientModel>) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Ingredients",
            style = MaterialTheme.typography.titleSmall,
            fontSize = 18.sp,
            modifier = Modifier.padding(end = 12.dp)
        )

        Divider(
            color = Color.Gray,
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
        )
    }
    FlowRow(
        mainAxisSize = SizeMode.Expand,
        mainAxisSpacing = 8.dp,
        mainAxisAlignment = FlowMainAxisAlignment.SpaceBetween,
        modifier = Modifier.padding(16.dp)
    ) {
        ingredientList.forEach {
            FoodIngredient(name = it.name, calories = it.calories)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FoodDetailScreenPreview() {
    MaterialTheme {
        //FoodDetailScreen()
    }
}
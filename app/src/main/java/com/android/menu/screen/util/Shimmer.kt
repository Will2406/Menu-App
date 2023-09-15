package com.android.menu.screen.util

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.android.menu.CategoryMainItemLoader
import com.android.menu.FoodMainItem
import com.android.menu.FoodMainItemLoader
import com.android.menu.ShimmerEffect
import com.android.menu.domain.core.toJson
import com.android.menu.domain.model.FoodModel
import com.android.menu.navigation.BottomBarNav
import com.android.menu.screen.home.TitleSection
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode


//HOME

@Composable
fun FoodSectionShimmer() {
    ShimmerEffect { brush ->
        val itemSize: Dp = (LocalConfiguration.current.screenWidthDp.dp / 2) - 12.dp
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(36.dp)
                .padding(horizontal = 16.dp)
                .background(brush)
        )

        FlowRow(
            mainAxisSize = SizeMode.Expand,
            mainAxisSpacing = 8.dp,
            mainAxisAlignment = FlowMainAxisAlignment.SpaceBetween,
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            for (i in 1..14) {
                FoodMainItemLoader(modifier = Modifier.width(itemSize), brush = brush)
            }
        }
    }
}


@Composable
fun CategorySectionShimmer() {
    ShimmerEffect { brush ->
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(36.dp)
                    .padding(horizontal = 16.dp)
                    .background(brush)
            )

            LazyRow(
                contentPadding = PaddingValues(start = 4.dp, end = 16.dp),
            ) {
                items(8) {
                    CategoryMainItemLoader(brush)
                }
            }
        }
    }
}
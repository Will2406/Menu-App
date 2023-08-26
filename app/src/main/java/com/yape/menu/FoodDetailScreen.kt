package com.yape.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import com.yape.menu.ui.theme.gray50Percent
import com.yape.menu.ui.theme.transparent


@Composable
fun FoodDetailScreen() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Box {
                HeaderComponent(
                    modifier = Modifier.zIndex(2f), title = "Details"
                )

                Image(
                    painter = painterResource(id = R.drawable.poke),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(360.dp)
                        .zIndex(0f)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .zIndex(1f)
                        .height(360.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(gray50Percent, transparent)
                            )
                        )
                )
            }
        }

        item { FoodDescription() }

        item { FoodIngredientList() }

        item {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                onClick = {},
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
fun FoodDescription(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row {
            Text(
                text = "Baked Salmon",
                style = MaterialTheme.typography.titleSmall,
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "$30",
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
                description = "4.4 Rating",
                type = FoodAttributeType.VERTICAL
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
                description = "400+ Reviews",
                type = FoodAttributeType.VERTICAL
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
                description = "100-300 Calories",
                type = FoodAttributeType.VERTICAL
            )
        }

        Text(
            text = "Baked salmon is a delicious and healthy dish that is perfect for a quick and easy weeknight dinner. The salmon fillets are seasoned with... View More ",
            style = MaterialTheme.typography.bodySmall,
            fontSize = 14.sp
        )
    }
}

@Composable
fun FoodIngredientList() {
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
        for (i in 1..26) {
            FoodIngredient()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FoodDetailScreenPreview() {
    MaterialTheme {
        FoodDetailScreen()
    }
}
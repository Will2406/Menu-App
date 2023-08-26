package com.yape.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension


@Composable
fun FoodMainItem(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .height(220.dp)
    ) {
        Column {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.poke),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier
                        .height(100.dp)
                        .clip(RoundedCornerShape(10.dp))
                )

                Box(
                    modifier = Modifier
                        .padding(horizontal = 6.dp, vertical = 6.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(12.dp))
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_rate),
                            contentDescription = null,
                            tint = Color(0xFFF6B789),
                            modifier = Modifier.height(16.dp)
                        )
                        Text(
                            text = "4.6",
                            modifier = Modifier.padding(horizontal = 2.dp),
                            fontSize = 16.sp,
                            style = MaterialTheme.typography.displayMedium
                        )
                    }

                }
            }

            Text(
                text = "Garden Salad",
                modifier = Modifier.padding(vertical = 4.dp),
                fontSize = 20.sp,
                style = MaterialTheme.typography.titleSmall
            )

            FoodItemAttribute(
                icon = R.drawable.ic_comment,
                description = "500+ reviews",
                type = FoodAttributeType.HORIZONTAL
            )

            FoodItemAttribute(
                icon = R.drawable.ic_calories,
                description = "100-300 calories",
                type = FoodAttributeType.HORIZONTAL
            )


            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "$12", fontSize = 18.sp, style = MaterialTheme.typography.titleSmall)
        }

    }
}

@Composable
fun FoodStatsItem(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .height(140.dp)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {

            val startGuideline = createGuidelineFromStart(0.45f)
            val (imageRef, descriptionRef) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.poke),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .constrainAs(imageRef) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(startGuideline)
                        width = Dimension.fillToConstraints
                    }
            )

            Column(
                modifier = Modifier
                    .padding(start = 16.dp, end = 12.dp)
                    .constrainAs(descriptionRef) {
                        start.linkTo(startGuideline)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    }
            ) {
                Text(
                    text = "Garden Salad",
                    modifier = Modifier.padding(vertical = 4.dp),
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.titleSmall
                )

                FoodItemAttribute(
                    icon = R.drawable.ic_comment,
                    description = "500+ reviews",
                    type = FoodAttributeType.HORIZONTAL
                )

                FoodItemAttribute(
                    icon = R.drawable.ic_calories,
                    description = "100-300 calories",
                    type = FoodAttributeType.HORIZONTAL
                )
            }
        }
    }
}

@Composable
fun FoodItemAttribute(modifier: Modifier = Modifier, icon: Int, description: String, type: FoodAttributeType) {
    when (type) {
        FoodAttributeType.HORIZONTAL -> {
            FoodItemAttributeHorizontal(modifier = modifier, icon = icon, description = description)
        }

        FoodAttributeType.VERTICAL -> {
            FoodItemAttributeVertical(modifier = modifier, icon = icon, description = description)
        }
    }
}


@Composable
private fun FoodItemAttributeHorizontal(modifier: Modifier = Modifier, icon: Int, description: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.height(16.dp)
        )
        Text(
            text = description,
            modifier = Modifier.padding(start = 4.dp),
            fontSize = 18.sp,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
private fun FoodItemAttributeVertical(modifier: Modifier = Modifier, icon: Int, description: String) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.height(16.dp)
        )
        Column(modifier = Modifier.padding(start = 4.dp)) {
            Text(
                text = description.split(" ").first(),
                modifier = Modifier.padding(start = 4.dp),
                fontSize = 18.sp,
                style = MaterialTheme.typography.displayMedium
            )
            Text(
                text = description.split(" ").last(),
                modifier = Modifier.padding(start = 4.dp),
                fontSize = 18.sp,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun FoodIngredient() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
    ) {
        Text(
            text = "Arroz",
            fontSize = 14.sp,
            style = MaterialTheme.typography.displayMedium
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "50 calories",
            fontSize = 14.sp,
            style = MaterialTheme.typography.displayMedium
        )
    }
}

enum class FoodAttributeType {
    HORIZONTAL,
    VERTICAL
}

@Preview(showBackground = true)
@Composable
fun FoodIngredientPreview() {
    MaterialTheme {
        FoodIngredient()
    }
}

@Preview(showBackground = true)
@Composable
fun FoodMainAttributePreview() {
    MaterialTheme {
        Column {
            FoodItemAttribute(
                icon = R.drawable.ic_comment,
                description = "500+ reviews",
                type = FoodAttributeType.HORIZONTAL
            )

            FoodItemAttribute(
                icon = R.drawable.ic_calories,
                description = "100-300 Calories",
                type = FoodAttributeType.VERTICAL
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FoodMainItemPreview() {
    MaterialTheme {
        FoodMainItem(modifier = Modifier.width(200.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun FoodStatsItemPreview() {
    MaterialTheme {
        FoodStatsItem()
    }
}
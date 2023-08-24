package com.yape.menu

import android.content.ClipData.Item
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryMainItem(text: String) {
    Box(
        modifier = Modifier
            .padding(start = 12.dp, top = 12.dp, bottom = 12.dp)
            .width(100.dp)
            .height(120.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.poke),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .height(80.dp)
                    .clip(RoundedCornerShape(10.dp))
            )

            Text(
                text = text,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                style = MaterialTheme.typography.displayMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryMainItemPreview() {
    MaterialTheme {
        CategoryMainItem(text = "Salad")
    }
}
package com.android.menu


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun CategoryMainItem(title: String = "", imageUrl: String = "") {
    Box(
        modifier = Modifier
            .padding(start = 12.dp, top = 12.dp, bottom = 12.dp)
            .width(100.dp)
            .height(150.dp)
    ) {
        Column {
            Image(
                painter = rememberAsyncImagePainter(imageUrl, contentScale = ContentScale.Crop),
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .height(100.dp)

            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = title,
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                style = MaterialTheme.typography.displayMedium
            )
        }
    }
}

@Composable
fun CategoryMainItemLoader(brush: Brush) {
    Box(
        modifier = Modifier
            .padding(start = 12.dp, top = 12.dp, bottom = 12.dp)
            .width(100.dp)
            .height(150.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .background(brush)
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Box(
                modifier = Modifier
                    .background(brush)
                    .fillMaxWidth()
                    .height(24.dp)

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryMainItemPreview() {
    MaterialTheme {
        CategoryMainItem(
            title = "Salad",
            imageUrl = "https://firebasestorage.googleapis.com/v0/b/chatapp-95bb6.appspot.com/o/Group%201.png?alt=media&token=0a322d69-3c27-45b7-ab1f-c32918ec17e9"
        )
    }
}
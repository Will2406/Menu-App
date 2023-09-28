package com.android.menu

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.android.menu.R


@Composable
fun HeaderComponent(
    modifier: Modifier = Modifier,
    title: String,
    isSaved: Boolean,
    onBackPressed: () -> Unit,
    onSavePressed: (state: Boolean) -> Unit
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .height(68.dp)
    ) {
        val (backButtonRef, titleRef, saveButtonRef) = createRefs()
        var stateSaveButton = remember { mutableStateOf(isSaved) }

        IconButton(
            onClick = { onBackPressed() },
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surface)
                .constrainAs(backButtonRef) {
                    linkTo(top = parent.top, bottom = parent.bottom)
                    start.linkTo(parent.start, margin = 16.dp)
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow),
                contentDescription = "Favorite",
                tint = MaterialTheme.colorScheme.outline
            )
        }

        Text(
            text = title,
            style = MaterialTheme.typography.displayMedium,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.constrainAs(titleRef) {
                linkTo(start = backButtonRef.end, end = saveButtonRef.start)
                linkTo(top = parent.top, bottom = parent.bottom)

            }
        )

        IconButton(
            onClick = {
                stateSaveButton.value = !stateSaveButton.value
                onSavePressed(stateSaveButton.value)
            },
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surface)
                .constrainAs(saveButtonRef) {
                    linkTo(top = parent.top, bottom = parent.bottom)
                    end.linkTo(parent.end, margin = 16.dp)
                }
        ) {
            Icon(
                painter = if (!stateSaveButton.value) painterResource(id = R.drawable.ic_bookmark) else painterResource(id = R.drawable.ic_bookmark_mark),
                contentDescription = "Favorite"
            )
        }

    }
}

@Composable
fun SocialMediaButton(onClick: () -> Unit, text: String, icon: Int, color: Color) {
    var click by remember { mutableStateOf(false) }
    Surface(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { click = !click },
        shape = RoundedCornerShape(50),
        border = BorderStroke(width = 1.dp, color = if (icon == R.drawable.ic_firebase) color else Color.Gray),
        color = color
    ) {
        Row(
            modifier = Modifier
                .padding(start = 12.dp, end = 16.dp, top = 12.dp, bottom = 12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = icon),
                modifier = Modifier.size(24.dp),
                contentDescription = text,
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "$text", color = if (icon == R.drawable.ic_firebase) Color.White else Color.Black)
            click = true
        }
    }
}


@Preview
@Composable
fun HeaderComponentPreview() {
    MaterialTheme {
        HeaderComponent(Modifier, title = "Details", false, {}, {})
    }
}
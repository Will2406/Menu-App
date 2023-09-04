package com.android.menu.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.android.menu.R

val fontLexend = FontFamily(
    Font(R.font.lexend_black),
    Font(R.font.lexend_bold, weight = FontWeight.Bold),
    Font(R.font.lexend_light, weight = FontWeight.Light),
    Font(R.font.lexend_thin, weight = FontWeight.Thin),
    Font(R.font.lexend_medium, weight = FontWeight.Medium),
    Font(R.font.lexend_extrabold, weight = FontWeight.ExtraBold)
)


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleSmall = TextStyle(
        fontFamily = fontLexend,
        fontWeight = FontWeight.Bold
    ),
    bodySmall = TextStyle(
        fontFamily = fontLexend,
        fontWeight = FontWeight.Light
    ),
    displayMedium =  TextStyle(
        fontFamily = fontLexend,
        fontWeight = FontWeight.Medium
    )


    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
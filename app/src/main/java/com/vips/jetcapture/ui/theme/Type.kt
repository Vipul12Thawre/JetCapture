package com.vips.jetcapture.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.vips.jetcapture.R

val appFontFamily = FontFamily(
    Font(resId = R.font.gothambllack, weight = FontWeight.Normal),
    Font(resId = R.font.gothambold, weight = FontWeight.Medium),
    Font(resId = R.font.gothamlight, weight = FontWeight.Light),
)

val TitleDefault = TextStyle(
    fontFamily = appFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 20.sp
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    subtitle1 = TitleDefault


)


package com.vips.jetcapture.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Grey40,
    primaryVariant = Grey40,
    secondary = Blue10,
    surface = Grey50
)

private val LightColorPalette = lightColors(
    primary = Grey20,
    primaryVariant = Grey30,
    secondary = Blue10,
    surface = Color.White
)

@Composable
fun JetCaptureTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
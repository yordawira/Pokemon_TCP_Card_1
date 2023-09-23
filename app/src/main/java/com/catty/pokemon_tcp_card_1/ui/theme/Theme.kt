package com.catty.pokemon_tcp_card_1.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val DarkColorPalette = darkColors(
    primary = Color(0xFF901010),
    background = Color(0xFF212121),
    onBackground = Color.White,
    surface = Color(0xFF303030),
    onSurface = Color.White
)

private val LightColorPalette = lightColors(
    primary = LightBlue,
    background = Color.LightGray,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black
)

@Composable
fun JetpackComposePokedexTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {

    // TODO: Add light theme, for the moment just dark theme is available :(
    val colors = //if (darkTheme) {
        DarkColorPalette
//    } else {
//        LightColorPalette
//    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
package com.example.spacevent.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Purple700,
    primaryVariant = PurpleAlpha,
    secondary = Yellow500,
    secondaryVariant = Yellow700,
    onSecondary = Purple700,
    background = Purple500,
    surface = Purple200,
    onSurface = Purple700,
)

private val LightColorPalette = lightColors(
    primary = Purple700,
    primaryVariant = PurpleAlpha,
    onPrimary = Blue,
    secondary = Yellow500,
    secondaryVariant = Yellow700,
    onSecondary = Purple700,
    background = Purple500,
    surface = Purple200,
    onSurface = Purple700,

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun SpaceventTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
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
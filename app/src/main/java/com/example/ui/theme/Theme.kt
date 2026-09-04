package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = TrendTealGlow,
    onPrimary = Color(0xFF042F2E),
    primaryContainer = TrendTealDark,
    onPrimaryContainer = Color(0xFFCCFBF1),
    secondary = TrendSaffronGlow,
    onSecondary = Color(0xFF451A03),
    secondaryContainer = Color(0xFF78350F),
    onSecondaryContainer = Color(0xFFFEF3C7),
    tertiary = TrendCinnamon,
    onTertiary = Color.White,
    background = TrendDarkCanvas,
    onBackground = TrendDarkOnSurface,
    surface = TrendDarkSurface,
    onSurface = TrendDarkOnSurface,
    surfaceVariant = TrendDarkSurfaceVariant,
    onSurfaceVariant = TrendDarkOnSurfaceMuted,
    outline = TrendDarkBorder
)

private val LightColorScheme = lightColorScheme(
    primary = TrendTealPrimary,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFCCFBF1),
    onPrimaryContainer = Color(0xFF115E59),
    secondary = TrendSaffron,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFFEF3C7),
    onSecondaryContainer = Color(0xFF78350F),
    tertiary = TrendCinnamon,
    onTertiary = Color.White,
    background = TrendLightCanvas,
    onBackground = TrendLightOnSurface,
    surface = TrendLightSurface,
    onSurface = TrendLightOnSurface,
    surfaceVariant = TrendLightSurfaceVariant,
    onSurfaceVariant = TrendLightOnSurfaceMuted,
    outline = TrendLightBorder
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Use 2026 Trend Color System intentionally
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

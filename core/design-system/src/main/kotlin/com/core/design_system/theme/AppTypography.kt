package com.core.design_system.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle

@Stable
data class AppTypography(
    val titleLarge: TextStyle,
    val titleMedium: TextStyle,
    val titleSmall: TextStyle,
    val body: TextStyle,
    val caption: TextStyle
)

internal val LocalAppTypography = staticCompositionLocalOf <AppTypography> {
    error("No typography provided")
}
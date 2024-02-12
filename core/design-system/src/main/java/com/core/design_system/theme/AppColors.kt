package com.core.design_system.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Stable
data class AppColors(
    val statusBar: Color,
    val primaryText: Color,
    val surface: Color,
    val error: Color
    //etc.
)

internal val LocalAppColors = staticCompositionLocalOf<AppColors> {
    error("No colors provided")
}

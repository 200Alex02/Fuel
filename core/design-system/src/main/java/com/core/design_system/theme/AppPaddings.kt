package com.core.design_system.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp

@Stable
data class AppPaddings(
    val small: Dp,
    val medium: Dp,
    val large: Dp,
    val extraLarge: Dp
)

internal val LocalAppPaddings = staticCompositionLocalOf<AppPaddings> {
    error("No paddings provides")
}
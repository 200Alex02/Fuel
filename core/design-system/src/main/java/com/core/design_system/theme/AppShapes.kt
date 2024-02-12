package com.core.design_system.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf

@Stable
data class AppShapes(
    val button: RoundedCornerShape,
    val card: RoundedCornerShape
    //etc.
)

internal val LocalAppShapes = staticCompositionLocalOf<AppShapes> {
    error("No shapes provided")
}
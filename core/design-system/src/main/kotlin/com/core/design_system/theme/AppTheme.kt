package com.core.design_system.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat

private val darkColors = AppColors(
    statusBar = lightStatusBarColor,
    primaryText = lightPrimaryTextColor,
    surface = lightSurfaceColor,
    error = lightErrorColor
)

private val lightColors = AppColors(
    statusBar = darkStatusBarColor,
    primaryText = darkPrimaryTextColor,
    surface = darkSurfaceColor,
    error = darkErrorColor
)

private val typography = AppTypography(
    titleLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    titleSmall = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    body = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)

private val shapes = AppShapes(
    button = RoundedCornerShape(14.dp),
    card = RoundedCornerShape(8.dp)
)

private val paddings = AppPaddings(
    small = 4.dp,
    medium = 8.dp,
    large = 12.dp,
    extraLarge = 24.dp
)

@Composable
fun AppTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (isDarkTheme) darkColors else lightColors

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.statusBar.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = isDarkTheme
        }
    }

    CompositionLocalProvider(
        LocalAppColors provides colorScheme,
        LocalAppPaddings provides paddings,
        LocalAppShapes provides shapes,
        LocalAppTypography provides typography,
        content = content
    )
}

object AppTheme {
    val colorScheme: AppColors
        @Composable get() = LocalAppColors.current

    val typography: AppTypography
        @Composable get() = LocalAppTypography.current

    val shapes: AppShapes
        @Composable get() = LocalAppShapes.current

    val paddings: AppPaddings
        @Composable get() = LocalAppPaddings.current
}
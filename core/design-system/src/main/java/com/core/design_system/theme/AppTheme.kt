package com.core.design_system.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat

private val darkColors = AppColors(
    statusBar = Pink80,
    primaryText = Purple80,
    surface = PurpleGrey80,
    error = Color.Red
)

private val lightColors = AppColors(
    statusBar = Pink40,
    primaryText = Purple40,
    surface = PurpleGrey40,
    error = Color.Red
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
internal fun AppTheme(
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
    internal val colorScheme: AppColors
        @Composable get() = LocalAppColors.current

    internal val typography: AppTypography
        @Composable get() = LocalAppTypography.current

    internal val shapes: AppShapes
        @Composable get() = LocalAppShapes.current

    internal val paddings: AppPaddings
        @Composable get() = LocalAppPaddings.current
}
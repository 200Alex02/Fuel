package com.core.design_system.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.core.common.util.UiText
import com.core.design_system.theme.AppTheme

@Composable
fun ValidateErrorText(
    modifier: Modifier = Modifier,
    errorMessage: UiText? = null,
    isError: Boolean = false,
) {
    val context = LocalContext.current

    Text(
        text = if (isError) errorMessage!!.asString(context) else "",
        color = AppTheme.colorScheme.error,
        style = AppTheme.typography.body,
        modifier = modifier
    )
}
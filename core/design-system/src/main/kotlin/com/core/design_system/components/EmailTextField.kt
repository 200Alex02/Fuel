package com.core.design_system.components

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun EmailTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier,
    @StringRes labelText: Int,
    @StringRes placeholder: Int,
    isError: Boolean = false
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = {onValueChanged(it)},
        singleLine = true,
        isError = isError,
        label = { Text(text = stringResource(id = labelText)) },
        placeholder = { Text(text = stringResource(id = placeholder)) },
        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email") }
    )
}
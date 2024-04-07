package com.core.design_system.components

import androidx.annotation.StringRes
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.core.design_system.R

@Composable
fun PasswordTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier,
    @StringRes labelText: Int,
    @StringRes placeholder: Int,
    isError: Boolean = false
) {
    var isVisible by remember { mutableStateOf(false) }

    val icon = if (isVisible) painterResource(id = R.drawable.icon_password_visible)
    else painterResource(id = R.drawable.icon_password_invisible)

    val visualTransformation = if (isVisible) VisualTransformation.None
    else PasswordVisualTransformation()

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = { onValueChanged(it) },
        isError = isError,
        label = { Text(text = stringResource(id = labelText)) },
        placeholder = { Text(text = stringResource(id = placeholder)) },
        leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Lock") },
        trailingIcon = {
            IconButton(onClick = { isVisible = !isVisible }) {
                Icon(painter = icon, contentDescription = "password_icon")
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = visualTransformation
    )
}
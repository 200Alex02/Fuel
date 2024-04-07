package com.feature.sign_up.ui.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.core.design_system.components.AuthButton
import com.core.design_system.components.EmailTextField
import com.core.design_system.components.PasswordTextField
import com.core.design_system.components.ValidateErrorText
import com.core.design_system.theme.AppTheme
import com.feature.sign_up.ui.R
import com.feature.sign_up.ui.components.FakeSignUpComponent
import com.feature.sign_up.ui.components.SignUpComponent
import com.feature.sign_up.ui.state.ValidateEvent
import kotlinx.coroutines.Dispatchers

@Composable
fun SignUpContent(component: SignUpComponent) {
    val state = component.signUpState.collectAsState(Dispatchers.Main.immediate)
    val formState = component.formState.collectAsState(Dispatchers.Main.immediate)

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.sign_up),
                style = AppTheme.typography.titleLarge,
                color = AppTheme.colorScheme.primaryText,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(top = AppTheme.paddings.small),
                text = stringResource(id = R.string.fill_info),
                style = AppTheme.typography.titleSmall,
                color = AppTheme.colorScheme.primaryText,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(AppTheme.space.large))
            EmailTextField(
                value = formState.value.email,
                onValueChanged = { email ->
                    component.onEvent(event = ValidateEvent.EmailChanged(email = email))
                },
                labelText = R.string.email,
                modifier = Modifier.fillMaxWidth(),
                placeholder = R.string.email,
                isError = formState.value.errorEmail != null
            )
            ValidateErrorText(
                isError = formState.value.errorEmail != null,
                errorMessage = formState.value.errorEmail,
                modifier = Modifier
                    .padding(top = AppTheme.paddings.small)
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(AppTheme.space.small))
            PasswordTextField(
                value = formState.value.password,
                onValueChanged = { password ->
                    component.onEvent(event = ValidateEvent.PasswordChanged(password = password))
                },
                labelText = R.string.password,
                modifier = Modifier.fillMaxWidth(),
                placeholder = R.string.password,
                isError = formState.value.errorPassword != null
            )
            ValidateErrorText(
                isError = formState.value.errorPassword != null,
                errorMessage = formState.value.errorPassword,
                modifier = Modifier
                    .padding(top = AppTheme.paddings.small)
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(AppTheme.space.small))
            PasswordTextField(
                value = formState.value.repeatedPassword,
                onValueChanged = { repeatedPassword ->
                    component.onEvent(event = ValidateEvent.RepeatedPasswordChanged(repeatedPassword = repeatedPassword))
                },
                labelText = R.string.repeated_password,
                modifier = Modifier.fillMaxWidth(),
                placeholder = R.string.repeated_password,
                isError = formState.value.errorRepeatedPassword != null
            )
            ValidateErrorText(
                isError = formState.value.errorRepeatedPassword != null,
                errorMessage = formState.value.errorRepeatedPassword,
                modifier = Modifier
                    .padding(top = AppTheme.paddings.small)
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(AppTheme.space.medium))
            AuthButton(
                title = stringResource(id = R.string.sign_up),
                onClick = {
                    component.onEvent(event = ValidateEvent.Submit)
                },
                loading = state.value.isLoading,
                success = state.value.success
            )
            Row(
                modifier = Modifier.padding(top = AppTheme.paddings.large),
                horizontalArrangement = Arrangement.spacedBy(AppTheme.space.extraSmall)
            ) {
                Text(
                    text = stringResource(id = R.string.have_account),
                    style = AppTheme.typography.titleSmall,
                    color = AppTheme.colorScheme.primaryText,
                    textAlign = TextAlign.Center
                )
                ClickableText(
                    text = AnnotatedString(
                        text = stringResource(id = R.string.sign_in),
                        SpanStyle(color = AppTheme.colorScheme.authText)
                    ),
                    onClick = { component.onSignInClick() },
                    style = AppTheme.typography.titleSmall,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    AppTheme {
        SignUpContent(FakeSignUpComponent())
    }
}
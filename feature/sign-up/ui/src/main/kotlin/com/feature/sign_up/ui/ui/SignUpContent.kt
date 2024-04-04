package com.feature.sign_up.ui.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.core.design_system.components.AuthButton
import com.core.design_system.components.EmailTextField
import com.core.design_system.components.PasswordTextField
import com.core.design_system.theme.AppTheme
import com.feature.sign_up.ui.R
import com.feature.sign_up.ui.components.FakeSignUpComponent
import com.feature.sign_up.ui.components.SignUpComponent
import kotlinx.coroutines.Dispatchers

@Composable
fun SignUpContent(component: SignUpComponent) {
    val state = component.signUpState.collectAsState(Dispatchers.Main.immediate)
    val email = component.email.collectAsState(Dispatchers.Main.immediate)
    val password = component.password.collectAsState(Dispatchers.Main.immediate)
    val repeatedPassword = component.repeatedPassword.collectAsState(Dispatchers.Main.immediate)

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
                text = stringResource(id = R.string.fill_info),
                style = AppTheme.typography.titleSmall,
                color = AppTheme.colorScheme.primaryText,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(50.dp))
            EmailTextField(
                value = email.value,
                onValueChanged = {
                    component.onEmailChanged(it)
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = R.string.email
            )
            Spacer(modifier = Modifier.height(15.dp))
            PasswordTextField(
                value = password.value,
                onValueChanged = {
                    component.onPasswordChanged(it)
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = R.string.password
            )
            Spacer(modifier = Modifier.height(15.dp))
            PasswordTextField(
                value = repeatedPassword.value,
                onValueChanged = {
                    component.onRepeatedPasswordChanged(it)
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = R.string.repeated_password
            )
            Spacer(modifier = Modifier.height(30.dp))
            AuthButton(
                title = stringResource(id = R.string.sign_up),
                onClick = {
                    component.signUpWithEmailAndPassword()
                    component.onSignUpClick()
                },
                loading = state.value.isLoading,
                success = state.value.success
            )
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
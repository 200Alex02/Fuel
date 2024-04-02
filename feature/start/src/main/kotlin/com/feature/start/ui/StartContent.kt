package com.feature.start.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.core.design_system.components.ButtonRectangle
import com.core.design_system.theme.AppTheme
import com.feature.start.components.StartComponent

@Composable
fun StartContent(component: StartComponent) {
    AppTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            /*Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = com.core.design_system.R.drawable.image_start_bg),
                contentDescription = "start_image_bg"
            )*/
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = AppTheme.paddings.extraLarge)
                        .padding(top = 200.dp),
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    ButtonRectangle(
                        onClick = {
                            component.onSignInClick()
                        },
                        backgroundColor = Color.Black,
                        content = {
                            Text(
                                text = stringResource(id = com.core.design_system.R.string.sign_in),
                                fontStyle = AppTheme.typography.titleSmall.fontStyle,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    )
                    ButtonRectangle(
                        onClick = {
                            component.onSingUpClick()
                        },
                        backgroundColor = Color.White,
                        content = {
                            Text(
                                text = stringResource(id = com.core.design_system.R.string.sign_up),
                                fontStyle = AppTheme.typography.titleSmall.fontStyle,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    )
                }
            }
        }
    }
}
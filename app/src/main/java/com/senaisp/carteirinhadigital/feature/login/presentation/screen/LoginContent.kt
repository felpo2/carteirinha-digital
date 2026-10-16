package com.senaisp.carteirinhadigital.feature.login.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.senaisp.carteirinhadigital.R
import com.senaisp.carteirinhadigital.feature.login.domain.model.UsuarioLogado
import com.senaisp.carteirinhadigital.feature.login.presentation.LoginEvent
import com.senaisp.carteirinhadigital.feature.login.presentation.LoginViewModel

@Composable
fun LoginContent(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel,
    onLoginSucesso: (UsuarioLogado) -> Unit,
    darkTheme: Boolean,
    onDarkThemeChange: (Boolean) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val colors = MaterialTheme.colorScheme

    LaunchedEffect(uiState.usuarioLogado) {
        uiState.usuarioLogado?.let { usuario ->
            viewModel.onEvent(LoginEvent.OnNavegacaoRealizada)
            onLoginSucesso(usuario)
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colors.background)
            .imePadding(),
        contentAlignment = Alignment.Center
    ) {
        TextButton(
            onClick = { onDarkThemeChange(!darkTheme) },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 16.dp, top = 8.dp)
        ) {
            Text(
                text = if (darkTheme) "Modo claro" else "Modo escuro",
                color = colors.onBackground,
                style = MaterialTheme.typography.labelLarge
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = 420.dp)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 32.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF282828))
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.senai_logo),
                    contentDescription = "SENAI",
                    modifier = Modifier.size(width = 206.dp, height = 55.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = "Portal Educacional",
                color = colors.onBackground,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Acesse sua conta",
                color = colors.onSurfaceVariant,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(38.dp))

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "E-mail",
                    color = colors.onBackground,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(6.dp))
                OutlinedTextField(
                    value = uiState.usuario,
                    onValueChange = { viewModel.onEvent(LoginEvent.OnUsuarioChange(it)) },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    isError = uiState.credentialError,
                    shape = RoundedCornerShape(8.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colors.primary,
                        unfocusedBorderColor = colors.outline,
                        focusedTextColor = colors.onSurface,
                        unfocusedTextColor = colors.onSurface,
                        cursorColor = colors.primary
                    )
                )
            }

            Spacer(modifier = Modifier.height(18.dp))
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Senha",
                    color = colors.onBackground,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(6.dp))
                OutlinedTextField(
                    value = uiState.senha,
                    onValueChange = { viewModel.onEvent(LoginEvent.OnSenhaChange(it)) },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    isError = uiState.credentialError,
                    visualTransformation = PasswordVisualTransformation(),
                    shape = RoundedCornerShape(8.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { viewModel.onEvent(LoginEvent.OnEntrarClick) }
                    ),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colors.primary,
                        unfocusedBorderColor = colors.outline,
                        focusedTextColor = colors.onSurface,
                        unfocusedTextColor = colors.onSurface,
                        cursorColor = colors.primary
                    )
                )
            }

            uiState.errorMessage?.let { message ->
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = message,
                    color = colors.error,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Spacer(modifier = Modifier.height(28.dp))
            Button(
                onClick = { viewModel.onEvent(LoginEvent.OnEntrarClick) },
                enabled = !uiState.isLoading,
                modifier = Modifier.fillMaxWidth().height(48.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colors.primary,
                    contentColor = colors.onPrimary
                )
            ) {
                if (uiState.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(22.dp),
                        color = colors.onPrimary,
                        strokeWidth = 2.dp
                    )
                } else {
                    Text("Entrar", style = MaterialTheme.typography.titleMedium)
                    Text("›", modifier = Modifier.padding(start = 6.dp), fontSize = 23.sp)
                }
            }
        }
    }
}

package com.senaisp.carteirinhadigital.feature.login.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.senaisp.carteirinhadigital.R
import com.senaisp.carteirinhadigital.app.navigation.Routes
import com.senaisp.carteirinhadigital.feature.login.domain.model.UsuarioLogado
import com.senaisp.carteirinhadigital.feature.login.presentation.LoginEvent
import com.senaisp.carteirinhadigital.feature.login.presentation.LoginViewModel

private val Background = Color(0xFF282828)
private val White = Color(0xFFF3F3F3)
private val Border = Color(0xFF969696)
private val TextWhite = Color.White.copy(alpha = 0.85f)

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController = NavController(
        LocalContext.current
    ),
    viewModel: LoginViewModel = viewModel(),
    onLoginSucesso:(UsuarioLogado)-> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(uiState.usuarioLogado) {
        uiState.usuarioLogado?.let {
            usuario ->
            viewModel.onEvent(LoginEvent.OnNavegacaoRealizada)
            onLoginSucesso(usuario)
        }
    }
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    var loginError by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Background)
            .padding(horizontal = 45.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier.weight(1f)
        )

        // Logo SENAI
        Image(
            painter = painterResource(
                id = R.drawable.senai_logo
            ),
            contentDescription = "SENAI",
            modifier = Modifier
                .size(
                    width = 206.dp,
                    height = 55.dp
                ),
            contentScale = ContentScale.Fit
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Portal Educacional",
            color = Color.White,
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = "Faça o login como Aluno ou Professor",
            color = Color.White.copy(alpha = 0.74f),
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(
            modifier = Modifier.height(70.dp)
        )

        // E-mail
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "E-mail",
                color = TextWhite,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(3.dp)
            )

            OutlinedTextField(
                value = ui.State.email,
                onValueChange = { value ->
                    viewModel.onEvent(LoginEvent.OnSenhaChange(value))
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Border,
                    unfocusedBorderColor = Border,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                )
            )
        }

        Spacer(
            modifier = Modifier.height(23.dp)
        )

        // Senha
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "Senha",
                color = TextWhite,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(3.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                    loginError = false
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                visualTransformation =
                    if (passwordVisible) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Border,
                    unfocusedBorderColor = Border,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                )
            )
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        if (loginError) {
            Text(
                text = "E-mail ou senha incorretos.",
                color = Color(0xFFFF6B6B),
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        // Botão Entrar
        Button(
            onClick = {

                when {
                    email == "aluno@senai.com" &&
                            password == "123456" -> {

                        navController.navigate(
                            Routes.Home.route
                        )
                    }

                    email == "professor@senai.com" &&
                            password == "123456" -> {

                        navController.navigate(
                            Routes.ProfessorHomeScreen.route
                        )
                    }

                    else -> {
                        loginError = true
                    }
                }

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(42.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = White,
                contentColor = Color.Black
            )
        ) {

            Text(
                text = "Entrar",
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black
            )

            Text(
                text = "›",
                modifier = Modifier.padding(start = 5.dp),
                fontSize = 25.sp,
                color = Color.Black
            )
        }

        Spacer(
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    widthDp = 390,
    heightDp = 844
)
@Composable
fun LoginScreenPreview() {
    // Preview sem navegação
}
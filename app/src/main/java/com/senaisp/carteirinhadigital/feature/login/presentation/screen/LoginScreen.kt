package com.senaisp.carteirinhadigital.feature.login.presentation.screen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.senaisp.carteirinhadigital.feature.login.domain.model.UsuarioLogado
import com.senaisp.carteirinhadigital.feature.login.presentation.LoginViewModel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onLoginSucesso: (UsuarioLogado) -> Unit,
    viewModel: LoginViewModel
) {
    LoginContent(
        modifier = modifier,
        viewModel = viewModel,
        onLoginSucesso = onLoginSucesso
    )
}
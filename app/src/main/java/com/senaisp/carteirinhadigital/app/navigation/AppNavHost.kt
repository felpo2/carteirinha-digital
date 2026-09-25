package com.senaisp.carteirinhadigital.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.senaisp.carteirinhadigital.app.di.AppContainer
import com.senaisp.carteirinhadigital.app.session.SessionViewModel
import com.senaisp.carteirinhadigital.feature.carteirinha.presentation.screen.CarteirinhaScreen
import com.senaisp.carteirinhadigital.feature.carteirinha.presentation.screen.HomeScreen
import com.senaisp.carteirinhadigital.feature.carteirinha.presentation.screen.ProfessorHomeScreen
import com.senaisp.carteirinhadigital.feature.login.presentation.LoginViewModel
import com.senaisp.carteirinhadigital.feature.login.presentation.LoginViewModelFactory
import com.senaisp.carteirinhadigital.feature.login.presentation.screen.LoginScreen
import com.senaisp.carteirinhadigital.feature.turmas.presentation.screen.TurmasScreen
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation.UnidadeCurricularViewModel
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation.factory.UnidadeCurricularViewModelFactory
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation.screen.ProfessorUnidadeCurricularScreen
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation.screen.UnidadeCurricularScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    sessionViewModel: SessionViewModel = viewModel(),
    container: AppContainer,
) {
    val usuario by sessionViewModel.usuarioLogado.collectAsStateWithLifecycle()

    fun sair() {
        container.authTokenStore.clearToken()
        sessionViewModel.limparSession()
        navController.navigate(Routes.Login.route) {
            popUpTo(navController.graph.id) { inclusive = true }
            launchSingleTop = true
        }
    }

    NavHost(navController = navController, startDestination = Routes.Login.route) {
        composable(Routes.Login.route) {
            val factory = remember(container.loginRepository) {
                LoginViewModelFactory(container.loginRepository)
            }
            val loginViewModel: LoginViewModel = viewModel(factory = factory)
            LoginScreen(
                viewModel = loginViewModel,
                onProfessorClick = {
                    container.authTokenStore.clearToken()
                    sessionViewModel.limparSession()
                    navController.navigate(Routes.ProfessorHome.route)
                },
                onLoginSucesso = { aluno ->
                    container.authTokenStore.setToken(aluno.token)
                    sessionViewModel.setUsuarioLogado(aluno)
                    navController.navigate(Routes.HomeAluno.route) {
                        popUpTo(Routes.Login.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.HomeAluno.route) {
            if (usuario == null) {
                LaunchedEffect(Unit) { sair() }
            } else {
                HomeScreen(navController = navController, nomeAluno = usuario!!.nome, onSair = ::sair)
            }
        }
        composable(Routes.Carteirinha.route) {
            if (usuario == null) {
                LaunchedEffect(Unit) { sair() }
            } else {
                CarteirinhaScreen(navController = navController, aluno = usuario!!)
            }
        }
        composable(Routes.UCAluno.route) {
            if (usuario == null) {
                LaunchedEffect(Unit) { sair() }
            } else {
                val factory = remember(container.unidadeCurricularRepository) {
                    UnidadeCurricularViewModelFactory(container.unidadeCurricularRepository)
                }
                val ucViewModel: UnidadeCurricularViewModel = viewModel(factory = factory)
                UnidadeCurricularScreen(navController = navController, viewModel = ucViewModel)
            }
        }

        composable(Routes.ProfessorHome.route) {
            ProfessorHomeScreen(navController = navController, onSair = ::sair)
        }
        composable(Routes.Turmas.route) { TurmasScreen(navController = navController) }
        composable(Routes.ProfessorUC.route) {
            ProfessorUnidadeCurricularScreen(navController = navController)
        }
    }
}

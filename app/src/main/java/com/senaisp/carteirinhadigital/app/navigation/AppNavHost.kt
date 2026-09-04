package com.senaisp.carteirinhadigital.app.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.senaisp.carteirinhadigital.app.session.SessionViewModel
import com.senaisp.carteirinhadigital.feature.carteirinha.presentation.screen.CarteirinhaScreen
import com.senaisp.carteirinhadigital.feature.carteirinha.presentation.screen.HomeScreen
import com.senaisp.carteirinhadigital.feature.login.presentation.screen.LoginScreen
import com.senaisp.carteirinhadigital.feature.professor.presentation.screen.ProfessorHomeScreen
import com.senaisp.carteirinhadigital.feature.turmas.presentation.screen.TurmasScreen
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation.screen.UnidadeCurricularScreen
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation.screen.ProfessorUnidadeCurricularScreen
import com.senaisp.carteirinhadigital.feature.carteirinha.presentation.screen.HomeScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    sessionViewModel: SessionViewModel = viewModel()
) {
    val usuarioLogado by sessionViewModel.usuarioLogado.collectAsStateWithLifecycle()
    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ) {
        composable(Routes.HomeScreen.route) {
            val usuario = usuarioLogado
            if (usuario == null) {
                LaunchedEffect(Unit) {
                    navController.navigate(Routes.Login.route)
                }
            } else {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        composable(Routes.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(Routes.Carteirinha.route) {
            CarteirinhaScreen(
                navController = navController
            )
        }
        composable(Routes.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Routes.ProfessorHomeScreen.route) {
            ProfessorHomeScreen(navController = navController)
        }
        composable(Routes.Turmas.route) {
            TurmasScreen(navController = navController)
        }
        composable(Routes.UnidadeCurricular.route) {
            UnidadeCurricularScreen(navController = navController)
        }
        composable(Routes.ProfessorUnidadeCurricular.route) {
            ProfessorUnidadeCurricularScreen(navController = navController)
        }
    }
}

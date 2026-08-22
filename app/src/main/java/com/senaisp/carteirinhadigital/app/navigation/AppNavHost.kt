package com.senaisp.carteirinhadigital.app.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.senaisp.carteirinhadigital.feature.carteirinha.presentation.screen.CarteirinhaScreen
import com.senaisp.carteirinhadigital.feature.carteirinha.presentation.screen.HomeScreen
import com.senaisp.carteirinhadigital.feature.login.presentation.screen.LoginScreen
import com.senaisp.carteirinhadigital.feature.professor.presentation.screen.ProfessorHomeScreen
import com.senaisp.carteirinhadigital.feature.turmas.presentation.screen.TurmasScreen
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation.screen.UnidadeCurricularScreen
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation.screen.ProfessorUnidadeCurricularScreen

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ) {
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

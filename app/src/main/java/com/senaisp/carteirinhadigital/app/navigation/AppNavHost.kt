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
import com.senaisp.carteirinhadigital.feature.carteirinha.presentation.screen.HomeScreen
import com.senaisp.carteirinhadigital.feature.login.presentation.screen.LoginScreen
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.domain.model.UnidadeCurricular
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation.component.UnidadeCurricularCard
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation.screen.UnidadeCurricularScreen

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ) {
        composable(Routes.Login.route) {
            LoginScreen(
                navController=navController
            )
        }
        composable(Routes.Carteirinha.route) {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                CarteirinhaScreen(
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
        composable (Routes.Home.route){
            HomeScreen(
                navController=navController
            )
        }
        composable (Routes.UnidadeCurricular.route){
            UnidadeCurricularScreen()
        }
    }
}
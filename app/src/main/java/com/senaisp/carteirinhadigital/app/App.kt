package com.senaisp.carteirinhadigital.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.senaisp.carteirinhadigital.app.di.AppContainer
import com.senaisp.carteirinhadigital.app.navigation.AppNavHost
import com.senaisp.carteirinhadigital.core.designsystem.theme.CarteirinhaDigital

@Composable
fun App(container: AppContainer) {
    CarteirinhaDigital() {
        val navController = rememberNavController()
        AppNavHost(
            navController = navController,
            container=container
        )
    }
}

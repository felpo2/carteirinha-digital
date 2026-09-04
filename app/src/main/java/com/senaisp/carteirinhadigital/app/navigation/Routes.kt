package com.senaisp.carteirinhadigital.app.navigation

sealed class Routes (val route: String){

    data object Login : Routes("login")
    data object Carteirinha : Routes("carteirinha")

    data object Home : Routes("Home")

    data object UnidadeCurricular : Routes("UnidadeCurricular")
    data object ProfessorUnidadeCurricular : Routes("ProfessorUnidadeCurricular")

    data object Turmas : Routes("turmas")

    data object ProfessorHomeScreen : Routes("professorHomeScreen")

    data object HomeScreen : Routes("homescreen")

}
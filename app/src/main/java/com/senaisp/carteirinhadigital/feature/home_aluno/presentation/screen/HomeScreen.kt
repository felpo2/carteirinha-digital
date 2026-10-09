package com.senaisp.carteirinhadigital.feature.home_aluno.presentation.screen

import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(
    navController: NavController = NavController(LocalContext.current),
    usuarioLogado: UsuarioLogado,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Olá, ${usuarioLogado.nome}",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainer
            )
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = usuarioLogado.curso,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "Turma: ${usuarioLogado.turma}"
                )
                Text(
                    text = "Matrícula: ${usuarioLogado.matricula}"
                )
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BotaoNavegacao(
                text = "Carteirinha",
                onClick = {
                    navController.navigate(Routes.Carteirinha.route)
                },
                modifier = Modifier.fillMaxWidth()
            )

            BotaoNavegacao(
                text = "Unidades Curriculares",
                onClick = {
                    navController.navigate(Routes.UCAluno.route)
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeScreenPreview() {
    CarteirinhaDigital2DEVESTTheme {
        HomeScreen(
            usuarioLogado = UsuarioLogado(
                id = "1",
                nome = "Rafael Costa",
                matricula = "2026000001",
                curso = "Desenvolvimento de Sistemas",
                turma = "2DEVEST-A",
                token = "token"
            )
        )
    }
}
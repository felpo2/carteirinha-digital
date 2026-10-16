package com.senaisp.carteirinhadigital.feature.professor.home.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.senaisp.carteirinhadigital.core.designsystem.theme.CarteirinhaDigital
import com.senaisp.carteirinhadigital.feature.home_aluno.presentation.component.BotaoNavegacao
import com.senaisp.carteirinhadigital.feature.login.domain.model.PerfilAcesso
import com.senaisp.carteirinhadigital.feature.login.domain.model.UsuarioLogado

private val FundoProfessor = Color(0xFF282828)
private val PainelProfessor = Color(0xFF3F3F3F)
private val TextoSecundario = Color(0xFFBFBFBF)

@Composable
fun HomeProfessorScreen(
    usuarioLogado: UsuarioLogado,
    onTurmasClick: () -> Unit,
    onUnidadesCurricularesClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 24.dp, vertical = 28.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Olá, ${usuarioLogado.nome}",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.SemiBold
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(MaterialTheme.colorScheme.surfaceContainer)
                .padding(22.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "ÁREA DO PROFESSOR",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Matrícula: ${usuarioLogado.matricula}",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Acesse suas turmas e unidades curriculares.",
                color = TextoSecundario,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            BotaoNavegacao(
                text = "Minhas Turmas",
                onClick = onTurmasClick,
                modifier = Modifier.fillMaxWidth()
            )
            BotaoNavegacao(
                text = "Unidades Curriculares",
                onClick = onUnidadesCurricularesClick,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeProfessorPreview() {
    CarteirinhaDigital(darkTheme = true) {
        HomeProfessorScreen(
            usuarioLogado = UsuarioLogado(
                id = "2",
                nome = "Professor Modelo",
                matricula = "PROF20260001",
                perfil = PerfilAcesso.PROFESSOR,
                curso = "",
                turma = "",
                token = "preview"
            ),
            onTurmasClick = {},
            onUnidadesCurricularesClick = {}
        )
    }
}

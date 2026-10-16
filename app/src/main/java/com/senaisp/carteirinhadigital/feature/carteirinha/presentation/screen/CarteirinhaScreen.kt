package com.senaisp.carteirinhadigital.feature.carteirinha.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.senaisp.carteirinhadigital.R
import com.senaisp.carteirinhadigital.core.designsystem.theme.appFontFamily
import com.senaisp.carteirinhadigital.feature.carteirinha.presentation.component.QrCode
import com.senaisp.carteirinhadigital.feature.login.domain.model.UsuarioLogado


@Composable
fun CarteirinhaScreen(
    navController: NavController,
    aluno: UsuarioLogado,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        Text(
            text = "‹",
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 43.sp,
            fontFamily = appFontFamily,
            fontWeight = FontWeight.Light,
            modifier = Modifier
                .padding(
                    start = 13.dp,
                    top = 10.dp
                )
                .clickable {
                    navController.popBackStack()
                }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 27.dp,
                    end = 27.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(
                modifier = Modifier.height(134.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.login),
                contentDescription = "Foto do aluno",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(142.dp)
                    .clip(CircleShape)
            )

            Spacer(
                modifier = Modifier.height(57.dp)
            )

            // Nome
            Text(
                text = aluno.nome,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 23.sp,
                fontFamily = appFontFamily,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(
                modifier = Modifier.height(21.dp)
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                InfoChip(text = aluno.curso, modifier = Modifier.fillMaxWidth())
                InfoChip(text = aluno.turma, modifier = Modifier.fillMaxWidth())
            }

            Spacer(
                modifier = Modifier.height(45.dp)
            )

            QrCode(
                conteudo = aluno.matricula
            )
        }
    }
}

@Composable
private fun InfoChip(
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .defaultMinSize(minHeight = 42.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(MaterialTheme.colorScheme.surfaceContainerHigh)
            .border(1.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(14.dp))
            .padding(horizontal = 14.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 13.sp,
            lineHeight = 18.sp,
            textAlign = TextAlign.Center,
            fontFamily = appFontFamily,
            fontWeight = FontWeight.Medium
        )
    }
}

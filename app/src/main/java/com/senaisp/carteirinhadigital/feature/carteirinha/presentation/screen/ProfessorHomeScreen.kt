package com.senaisp.carteirinhadigital.feature.professor.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.senaisp.carteirinhadigital.app.navigation.Routes

private val Background = Color(0xFF282828)
private val CardColor = Color(0xFF595959).copy(alpha = 0.20f)
private val White = Color(0xFFF3F3F3)

@Composable
fun ProfessorHomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Background)
            .padding(start = 32.dp, end = 32.dp, top = 65.dp, bottom = 64.dp)
    ) {
        Text(
            text = "Seja bem-vindo, Felipe",
            color = Color.White,
            fontSize = 23.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Professor",
            color = Color.White.copy(alpha = 0.76f),
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.weight(1f))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Selecione uma das opções:",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(30.dp))
            ProfessorOptionCard(text = "Turmas") {
                navController.navigate(Routes.Turmas.route)
            }
            Spacer(modifier = Modifier.height(30.dp))
            ProfessorOptionCard(text = "Unidades Curriculares") {
                navController.navigate(Routes.ProfessorUnidadeCurricular.route)
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(42.dp)
                .background(White, RoundedCornerShape(9.dp))
                .clickable {
                    navController.navigate(Routes.Login.route) {
                        popUpTo(0)
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Sair",
                    color = Color.Black,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
private fun ProfessorOptionCard(
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(124.dp)
            .shadow(4.dp, RoundedCornerShape(24.dp))
            .background(CardColor, RoundedCornerShape(24.dp))
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                color = White.copy(alpha = 0.90f),
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
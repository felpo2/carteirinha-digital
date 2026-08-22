package com.senaisp.carteirinhadigital.feature.carteirinha.presentation.screen

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.senaisp.carteirinhadigital.R
import com.senaisp.carteirinhadigital.core.designsystem.theme.appFontFamily
import com.senaisp.carteirinhadigital.feature.carteirinha.presentation.component.QrCode

private val Background = Color(0xFF282828)
private val White = Color(0xFFFFFFFF)
private val ChipColor = Color(0x36ADADAD)

@Composable
fun CarteirinhaScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Background)
    ) {

        Text(
            text = "‹",
            color = White,
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
                text = "Felipe Thomaz A. Mikalauskas",
                color = White,
                fontSize = 23.sp,
                fontFamily = appFontFamily,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(
                modifier = Modifier.height(21.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(17.dp)
            ) {

                InfoChip(
                    text = "Dev. de Sistemas",
                    modifier = Modifier.weight(1f)
                )

                InfoChip(
                    text = "2DEVEST-B",
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(
                modifier = Modifier.height(45.dp)
            )

            QrCode(
                conteudo = "jkhgkgfhgf"
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
            .height(29.dp)
            .shadow(
                elevation = 3.dp,
                shape = RoundedCornerShape(35.dp)
            )
            .background(
                color = ChipColor,
                shape = RoundedCornerShape(35.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = White,
            fontSize = 12.sp,
            fontFamily = appFontFamily,
            fontWeight = FontWeight.Medium
        )
    }
}
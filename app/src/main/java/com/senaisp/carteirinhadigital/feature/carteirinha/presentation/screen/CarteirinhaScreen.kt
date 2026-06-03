package com.senaisp.carteirinhadigital.feature.carteirinha.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.senaisp.carteirinhadigital.feature.carteirinha.presentation.component.PerfilAluno
import com.senaisp.carteirinhadigital.R
import com.senaisp.carteirinhadigital.feature.carteirinha.presentation.component.QrCode


@Composable
fun CarteirinhaScreen(
    modifier: Modifier = Modifier
) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.fundo),
            contentDescription = "Fundo",
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.5f),
            contentScale = ContentScale.Crop
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = modifier.fillMaxSize()

        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo Senai",
                modifier = Modifier
                    .fillMaxWidth(0.8f)
            )
            PerfilAluno(
                nome = "Rafael Costa",
                curso = "Desenvolvimento de Sistemas"
            )
            QrCode(
                conteudo = "jkhgkgfhgf"
            )
        }

    }

}
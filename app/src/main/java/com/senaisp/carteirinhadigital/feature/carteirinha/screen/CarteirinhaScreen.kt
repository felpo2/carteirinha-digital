package com.senaisp.carteirinhadigital.feature.carteirinha.screen

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.senaisp.carteirinhadigital.R
import com.senaisp.carteirinhadigital.feature.carteirinha.presentation.component.LabelText
import com.senaisp.carteirinhadigital.feature.carteirinha.presentation.component.ValueText
import java.lang.reflect.Modifier

@Composable
fun CarteirinhaScreen(modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier){

    Box{
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Fundo",
            modifier = androidx.compose.ui.Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = androidx.compose.ui.Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Spacer(modifier = androidx.compose.ui.Modifier.height(50.dp))
            Image(
                painter = painterResource(id = R.drawable.senaiazul),
                contentDescription = "logo",
                modifier = androidx.compose.ui.Modifier
                    .padding(20.dp)
                    .width(400.dp),
                contentScale = ContentScale.FillWidth,
            )
            Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.perfil),
                contentDescription = "perfil",
                modifier = androidx.compose.ui.Modifier
                    .width(300.dp),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))




            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = androidx.compose.ui.Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                LabelText(
                    text = "Nome:",
                    modifier = androidx.compose.ui.Modifier
                        .weight(1f)
                )
                ValueText(
                    text = "Felipe Thomaz",
                    modifier = androidx.compose.ui.Modifier
                        .weight(1f)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = androidx.compose.ui.Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                LabelText(
                    text = "Curso:",
                    modifier = androidx.compose.ui.Modifier
                        .weight(1f)
                )
                ValueText(
                    text = "Desenvolvimento de Sistemas",
                    fontSize = 20.sp,
                    modifier = androidx.compose.ui.Modifier
                        .weight(1f)
                )
            }

            Spacer(modifier = androidx.compose.ui.Modifier.height(100.dp))

            Image(
                painter = painterResource(id = R.drawable.qrcode),
                contentDescription = "qrcode",
                modifier = androidx.compose.ui.Modifier
                    .size(200.dp) ,
                contentScale = ContentScale.FillWidth
            )

        }
    }
}

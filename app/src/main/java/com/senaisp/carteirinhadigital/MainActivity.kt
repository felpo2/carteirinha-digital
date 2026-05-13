package com.senaisp.carteirinhadigital

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.senaisp.carteirinhadigital.ui.theme.CarteirinhaDigitalTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarteirinhaDigitalTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CarteirinhaDigitalApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CarteirinhaDigitalApp(modifier: Modifier = Modifier){

    Box{
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Fundo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Spacer(modifier = Modifier.height(50.dp))
            Image(
                painter = painterResource(id = R.drawable.senaiazul),
                contentDescription = "logo",
                modifier = Modifier
                    .padding(20.dp)
                    .width(400.dp),
                contentScale = ContentScale.FillWidth,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                    painter = painterResource(id = R.drawable.perfil),
            contentDescription = "perfil",
            modifier = Modifier
                .width(300.dp),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(30.dp))


            Row() {

                Text(
                    text = "Nome: ",
                    fontSize = 20.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Felipe Thomaz",
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(3.dp))
            }

            Row() {
                Text(
                    text = "Curso: ",
                    fontSize = 20.sp,
                    color = Color.Black

                )
                Text(
                    text = "Desenvolvimento de Sistemas",
                    fontSize = 20.sp,
                    color = Color.Black
                )

            }
            Spacer(modifier = Modifier.height(100.dp))

            Image(
                painter = painterResource(id = R.drawable.qrcode),
                contentDescription = "qrcode",
                modifier = Modifier
                    .size(200.dp) ,
                    contentScale = ContentScale.FillWidth
            )

        }
    }
}
package com.senaisp.carteirinhadigital.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.senaisp.carteirinhadigital.core.designsystem.theme.CarteirinhaDigitalTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import com.senaisp.carteirinhadigital.feature.carteirinha.presentation.component.LabelText
import com.senaisp.carteirinhadigital.R
import com.senaisp.carteirinhadigital.feature.carteirinha.presentation.component.ValueText
import com.senaisp.carteirinhadigital.feature.carteirinha.screen.CarteirinhaScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarteirinhaDigitalTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CarteirinhaScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}






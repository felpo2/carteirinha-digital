package com.senaisp.carteirinhadigital.feature.turmas.presentation.screen

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

private val Background = Color(0xFF282828)
private val Panel = Color(0xFFD9D9D9)
private val PanelDark = Color(0xFFBFBFBF)
private val RowDark = Color(0xFF818181)
private val White = Color.White

@Composable
fun TurmasScreen(
    navController: NavController
) {
    var selectedStudent by remember { mutableStateOf<Int?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Text(
            text = "‹",
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 17.dp, top = 14.dp)
                .clickable { navController.popBackStack() },
            color = White,
            fontSize = 42.sp,
            fontWeight = FontWeight.Light
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 62.dp)
                .fillMaxWidth(0.80f)
                .height(43.dp)
                .shadow(4.dp, RoundedCornerShape(35.dp))
                .clip(RoundedCornerShape(35.dp))
                .background(Color(0xFF4B4B4B)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Turmas",
                color = White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 150.dp)
                .fillMaxWidth(0.77f)
                .height(616.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFF454545))
                .padding(horizontal = 22.dp, vertical = 22.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(448.dp)
                    .clip(RoundedCornerShape(11.dp))
                    .background(Panel)
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(91.dp)
                            .background(PanelDark),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text("2DEVEST-B", fontSize = 17.sp, fontWeight = FontWeight.Medium)
                        Text("Projeto de Software", fontSize = 15.sp, color = Color.Black.copy(alpha = .62f))
                        Spacer(Modifier.height(16.dp))
                        Text("16:00-16:45", fontSize = 15.sp, fontWeight = FontWeight.Medium)
                    }

                    (1..7).forEach { number ->
                        StudentRow(
                            number = number,
                            expanded = selectedStudent == number,
                            onClick = {
                                selectedStudent = if (selectedStudent == number) null else number
                            }
                        )
                    }
                }
            }

            Spacer(Modifier.height(14.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(123.dp)
                    .clip(RoundedCornerShape(11.dp))
                    .background(PanelDark),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    text = "⌄",
                    modifier = Modifier.padding(bottom = 2.dp),
                    color = Color.Black,
                    fontSize = 25.sp
                )
            }
        }
    }
}

@Composable
private fun StudentRow(
    number: Int,
    expanded: Boolean,
    onClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
                .background(Panel)
                .clickable(onClick = onClick),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 3.dp)
                    .size(26.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .background(White),
                contentAlignment = Alignment.Center
            ) {
                Text(number.toString(), fontSize = 15.sp)
            }

            Text(
                text = "Fulano Ciclano Beltrano",
                modifier = Modifier.padding(start = 17.dp).weight(1f),
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                maxLines = 1
            )

            Text(
                text = if (expanded) "⌃" else "⌄",
                modifier = Modifier.padding(end = 8.dp),
                fontSize = 18.sp
            )
        }

        if (expanded && number <= 3) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp)
                    .background(RowDark)
                    .padding(start = 6.dp, end = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .width(61.dp)
                        .height(23.dp)
                        .clip(RoundedCornerShape(3.dp))
                        .background(Panel),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Nota", fontSize = 11.sp, color = Color.Black.copy(alpha = .25f))
                }

                Spacer(Modifier.weight(1f))

                SmallAction("✓")
                Spacer(Modifier.width(8.dp))
                SmallAction("×")
            }
        }
    }
}

@Composable
private fun SmallAction(text: String) {
    Box(
        modifier = Modifier
            .size(23.dp)
            .clip(RoundedCornerShape(3.dp))
            .background(Panel),
        contentAlignment = Alignment.Center
    ) {
        Text(text, fontSize = 20.sp)
    }
}

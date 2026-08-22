package com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.domain.model.UnidadeCurricular

private val CardColor = Color(0xFFD9D9D9)
private val StatColor = Color(0xFFEEEEEE)
private val SecondaryText = Color.Black.copy(alpha = 0.62f)

@Composable
fun UnidadeCurricularCard(
    modifier: Modifier = Modifier,
    unidadeCurricular: UnidadeCurricular
) {
    Column(
        modifier = modifier
            .width(266.dp)
            .height(138.dp)
            .background(CardColor, RoundedCornerShape(11.dp))
            .padding(horizontal = 22.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = unidadeCurricular.nome,
            fontSize = 17.sp,
            lineHeight = 22.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            maxLines = 1
        )
        Text(
            text = "Prof: ${unidadeCurricular.professor}",
            fontSize = 15.sp,
            lineHeight = 19.sp,
            fontWeight = FontWeight.Medium,
            color = SecondaryText,
            maxLines = 1
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp),
            horizontalArrangement = Arrangement.spacedBy(17.dp)
        ) {
            UnidadeCurricularStat(
                label = "Presença",
                value = "${unidadeCurricular.presenca}%"
            )
            UnidadeCurricularStat(
                label = "Nota",
                value = formatNota(unidadeCurricular.media)
            )
        }
    }
}

@Composable
private fun UnidadeCurricularStat(
    label: String,
    value: String
) {
    Column(
        modifier = Modifier
            .width(109.dp)
            .height(58.dp)
            .background(StatColor, RoundedCornerShape(10.dp))
            .padding(top = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            fontSize = 15.sp,
            lineHeight = 19.sp,
            fontWeight = FontWeight.Medium,
            color = SecondaryText
        )
        Text(
            text = value,
            fontSize = 20.sp,
            lineHeight = 24.sp,
            color = Color.Black
        )
    }
}

private fun formatNota(nota: Double): String =
    if (nota % 1.0 == 0.0) nota.toInt().toString() else "%.2f".format(nota)


package com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.domain.model.UnidadeCurricular

@Composable
fun UnidadeCurricularCard(
    modifier: Modifier = Modifier,
    unidadeCurricular: UnidadeCurricular
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surfaceContainerHigh,
                shape = RoundedCornerShape(11.dp)
            )
            .padding(
                horizontal = 22.dp,
                vertical = 14.dp
            ),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Text(
            text = unidadeCurricular.nome,
            fontSize = 17.sp,
            lineHeight = 22.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = 2
        )

        Text(
            text = "Prof: ${unidadeCurricular.professor}",
            fontSize = 15.sp,
            lineHeight = 19.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 2
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            UnidadeCurricularStat(
                label = "Faltas",
                value = unidadeCurricular.faltas.toString(),
                modifier = Modifier.weight(1f)
            )

            UnidadeCurricularStat(
                label = "Nota",
                value = formatNota(unidadeCurricular.media),
                modifier = Modifier.weight(1f)
            )
        }

        Text(
            text = "N1: ${formatNota(unidadeCurricular.nota1)}   " +
                    "N2: ${formatNota(unidadeCurricular.nota2)}",
            fontSize = 13.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
private fun UnidadeCurricularStat(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .height(58.dp)
            .background(
                color = MaterialTheme.colorScheme.surfaceContainerLow,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(top = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = label,
            fontSize = 15.sp,
            lineHeight = 19.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            text = value,
            fontSize = 20.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

private fun formatNota(nota: Double): String {
    return if (nota % 1.0 == 0.0) {
        nota.toInt().toString()
    } else {
        String.format(Locale.forLanguageTag("pt-BR"), "%.2f", nota)
    }
}

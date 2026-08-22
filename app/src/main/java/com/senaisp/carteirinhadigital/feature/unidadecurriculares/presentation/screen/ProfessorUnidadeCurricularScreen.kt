package com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.data.dataSource
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation.component.UnidadeCurricularCard

private val Background = Color(0xFF282828)
private val Header = Color(0xFF4B4B4B)
private val Container = Color(0xFF3F3F3F)

@Composable
fun ProfessorUnidadeCurricularScreen(
    modifier: Modifier = Modifier,
    navController: NavController? = null
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Text(
            text = "‹",
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 17.dp, top = 12.dp)
                .clickable { navController?.popBackStack() },
            color = Color.White,
            fontSize = 42.sp,
            fontWeight = FontWeight.Light
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 62.dp)
                .fillMaxWidth(0.832f)
                .height(43.dp)
                .shadow(4.dp, RoundedCornerShape(35.dp))
                .clip(RoundedCornerShape(35.dp))
                .background(Header),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Unidades Curriculares",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 152.dp)
                .fillMaxWidth(0.796f)
                .height(616.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Container)
                .shadow(4.dp, RoundedCornerShape(20.dp))
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 28.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(28.dp)
            ) {
                items(dataSource()) { unidadeCurricular ->
                    UnidadeCurricularCard(unidadeCurricular = unidadeCurricular)
                }
            }
        }
    }
}

package com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation.UnidadeCurricularViewModel
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation.component.UnidadeCurricularCard


@Composable
fun UnidadeCurricularScreen(
    modifier: Modifier = Modifier,
    navController: NavController? = null,
    viewModel: UnidadeCurricularViewModel
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(viewModel) { viewModel.carregar() }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 62.dp)
                .fillMaxWidth(0.832f)
                .height(43.dp)
                .shadow(4.dp, RoundedCornerShape(35.dp))
                .clip(RoundedCornerShape(35.dp))
                .background(MaterialTheme.colorScheme.surfaceContainerHigh),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Unidades Curriculares",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 152.dp)
                .fillMaxWidth(0.796f)
                .height(62.dp)
                .clip(RoundedCornerShape(17.dp))
                .background(Color.White.copy(alpha = 0.08f)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "${uiState.unidades.size} disciplinas",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 251.dp)
                .fillMaxWidth(0.796f)
                .height(616.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(MaterialTheme.colorScheme.surfaceContainer)
                .shadow(4.dp, RoundedCornerShape(20.dp))
        ) {
            when {
                uiState.isLoading -> CircularProgressIndicator(Modifier.align(Alignment.Center), color = Color.White)
                uiState.errorMessage != null -> Column(
                    modifier = Modifier.align(Alignment.Center).padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(uiState.errorMessage!!, color = Color.White)
                    Button(onClick = viewModel::carregar) { Text("Tentar novamente") }
                }
                uiState.unidades.isEmpty() -> Text(
                    "Nenhuma unidade curricular encontrada.",
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center).padding(20.dp)
                )
                else -> LazyColumn(
                    modifier = Modifier.fillMaxSize().padding(top = 28.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(28.dp)
                ) {
                    items(uiState.unidades, key = { it.id }) { unidadeCurricular ->
                        UnidadeCurricularCard(unidadeCurricular = unidadeCurricular)
                    }
                }
            }
        }
    }
}

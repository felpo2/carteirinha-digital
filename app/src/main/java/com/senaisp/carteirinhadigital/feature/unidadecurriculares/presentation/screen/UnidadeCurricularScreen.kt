package com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.data.dataSource
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.domain.model.UnidadeCurricular
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation.component.UnidadeCurricularCard

@Composable
fun UnidadeCurricularScreen(
    modifier: Modifier = Modifier,
    unidadesCurriculares : List<UnidadeCurricular>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(unidadesCurriculares) { unidadeCurricular ->
            UnidadeCurricularCard(unidadeCurricular = unidadeCurricular)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UnidadeCurricularScreenPreview() {
    // Aqui nós "executamos" a sua função para pegar a lista cheia de matérias
    val dadosDoDataSource = dataSource()

    // E passamos esses dados para a sua tela
    UnidadeCurricularScreen(unidadesCurriculares = dadosDoDataSource)
}
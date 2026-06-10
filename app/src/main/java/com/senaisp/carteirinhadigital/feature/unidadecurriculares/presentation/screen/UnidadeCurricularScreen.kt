package com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.data.dataSource
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.domain.model.UnidadeCurricular
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation.component.UnidadeCurricularCard

@Composable
fun UnidadeCurricularScreen(
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(dataSource()) { unidadeCurricular ->
            UnidadeCurricularCard(unidadeCurricular = unidadeCurricular)
        }
    }
}

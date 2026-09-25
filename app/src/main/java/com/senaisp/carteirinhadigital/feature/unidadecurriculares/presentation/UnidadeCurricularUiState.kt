package com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation

import com.senaisp.carteirinhadigital.feature.unidadecurriculares.domain.model.UnidadeCurricular

data class UnidadeCurricularUiState(
    val listaUnidadesCurriculares: List<UnidadeCurricular> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) {
}
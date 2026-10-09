package com.senaisp.carteirinhadigital.feature.unidadecurriculares.presentation

import com.senaisp.carteirinhadigital.feature.unidadecurriculares.domain.model.UnidadeCurricular

data class UnidadeCurricularUiState(
    val isLoading: Boolean = false,
    val unidades: List<UnidadeCurricular> = emptyList(),
    val errorMessage: String? = null
)
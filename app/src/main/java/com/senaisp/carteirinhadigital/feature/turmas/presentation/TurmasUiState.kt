package com.senaisp.carteirinhadigital.feature.turmas.presentation

import com.senaisp.carteirinhadigital.feature.turmas.domain.model.Turma

data class TurmasUiState(
    val isLoading: Boolean = false,
    val turmas: List<Turma> = emptyList(),
    val errorMessage: String? = null
)

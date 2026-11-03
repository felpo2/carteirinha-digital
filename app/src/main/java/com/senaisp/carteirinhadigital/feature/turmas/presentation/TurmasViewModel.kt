package com.senaisp.carteirinhadigital.feature.turmas.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.senaisp.carteirinhadigital.feature.turmas.domain.repository.TurmaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TurmasViewModel(
    private val repository: TurmaRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(TurmasUiState())
    val uiState: StateFlow<TurmasUiState> = _uiState.asStateFlow()

    fun carregar() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true,
                    errorMessage = null
                )
            }
            repository.listar()
                .onSuccess { turmas ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            turmas = turmas,
                            errorMessage = null
                        )
                    }
                }
                .onFailure { throwable ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = throwable.message ?: "Erro ao carregar turmas."
                        )
                    }
                }
        }
    }
}

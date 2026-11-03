package com.senaisp.carteirinhadigital.feature.turmas.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.senaisp.carteirinhadigital.feature.turmas.domain.repository.TurmaRepository
import com.senaisp.carteirinhadigital.feature.turmas.presentation.TurmasViewModel

class TurmasViewModelFactory(
    private val repository: TurmaRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TurmasViewModel::class.java)) {
            return TurmasViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel desconhecida: ${modelClass.name}")
    }
}

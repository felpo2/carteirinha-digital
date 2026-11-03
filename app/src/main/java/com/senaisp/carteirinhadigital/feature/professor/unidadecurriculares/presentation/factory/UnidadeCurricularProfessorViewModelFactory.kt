package com.senaisp.carteirinhadigital.feature.professor.unidadecurriculares.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.senaisp.carteirinhadigital.feature.professor.unidadecurriculares.domain.repository.ProfessorUnidadeCurricularRepository
import com.senaisp.carteirinhadigital.feature.professor.unidadecurriculares.presentation.UnidadeCurricularProfessorViewModel

class UnidadeCurricularProfessorViewModelFactory(
    private val repository: ProfessorUnidadeCurricularRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UnidadeCurricularProfessorViewModel::class.java)) {
            return UnidadeCurricularProfessorViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel desconhecida: ${modelClass.name}")
    }
}

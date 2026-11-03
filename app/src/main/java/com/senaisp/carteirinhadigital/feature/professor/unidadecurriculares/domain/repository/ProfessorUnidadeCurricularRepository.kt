package com.senaisp.carteirinhadigital.feature.professor.unidadecurriculares.domain.repository

import com.senaisp.carteirinhadigital.feature.professor.unidadecurriculares.domain.model.UnidadeCurricularProfessor

interface ProfessorUnidadeCurricularRepository {
    suspend fun listar(): Result<List<UnidadeCurricularProfessor>>
}

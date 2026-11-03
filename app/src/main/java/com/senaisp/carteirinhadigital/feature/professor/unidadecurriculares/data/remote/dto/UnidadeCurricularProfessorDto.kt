package com.senaisp.carteirinhadigital.feature.professor.unidadecurriculares.data.remote.dto

import com.senaisp.carteirinhadigital.feature.professor.unidadecurriculares.domain.model.UnidadeCurricularProfessor
import kotlinx.serialization.Serializable

@Serializable
data class UnidadeCurricularProfessorDto(
    val id: String = "",
    val nome: String = "",
    val turmaId: String = "",
    val turma: String = "",
    val cargaHoraria: Int = 0,
    val quantidadeAulas: Int = 0,
    val aulasRealizadas: Int = 0,
    val diasSemana: List<String> = emptyList(),
    val horarioInicio: String = "",
    val horarioFim: String = ""
) {
    fun toDomain(): UnidadeCurricularProfessor {
        return UnidadeCurricularProfessor(
            id = id,
            nome = nome,
            turmaId = turmaId,
            turma = turma,
            cargaHoraria = cargaHoraria,
            quantidadeAulas = quantidadeAulas,
            aulasRealizadas = aulasRealizadas,
            diasSemana = diasSemana,
            horarioInicio = horarioInicio,
            horarioFim = horarioFim
        )
    }
}

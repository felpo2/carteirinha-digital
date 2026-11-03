package com.senaisp.carteirinhadigital.feature.turmas.data.remote.dto

import com.senaisp.carteirinhadigital.feature.turmas.domain.model.Turma
import kotlinx.serialization.Serializable

@Serializable
data class TurmaProfessorDto(
    val id: String = "",
    val codigo: String = "",
    val curso: String = "",
    val semestre: String = "",
    val quantidadeAlunos: Int = 0,
    val diasSemana: List<String> = emptyList(),
    val horarioInicio: String = "",
    val horarioFim: String = ""
) {
    fun toDomain(): Turma {
        return Turma(
            id = id,
            codigo = codigo,
            curso = curso,
            semestre = semestre,
            quantidadeAlunos = quantidadeAlunos,
            diasSemana = diasSemana,
            horarioInicio = horarioInicio,
            horarioFim = horarioFim
        )
    }
}

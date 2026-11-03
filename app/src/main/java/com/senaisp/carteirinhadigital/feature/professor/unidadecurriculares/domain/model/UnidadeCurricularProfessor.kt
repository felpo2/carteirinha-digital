package com.senaisp.carteirinhadigital.feature.professor.unidadecurriculares.domain.model

data class UnidadeCurricularProfessor(
    val id: Long,
    val nome: String,
    val turmaId: Long,
    val turma: String,
    val cargaHoraria: Int,
    val quantidadeAulas: Int,
    val aulasRealizadas: Int,
    val diasSemana: List<String>,
    val horarioInicio: String,
    val horarioFim: String
)

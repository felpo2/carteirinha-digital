package com.senaisp.carteirinhadigital.feature.turmas.domain.repository

import com.senaisp.carteirinhadigital.feature.turmas.domain.model.Turma

interface TurmaRepository {
    suspend fun listar(): Result<List<Turma>>
}

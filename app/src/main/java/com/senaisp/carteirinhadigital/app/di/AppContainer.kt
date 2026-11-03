package com.senaisp.carteirinhadigital.app.di

import com.senaisp.carteirinhadigital.core.auth.SessionTokenStore
import com.senaisp.carteirinhadigital.feature.login.domain.repository.LoginRepository
import com.senaisp.carteirinhadigital.feature.professor.unidadecurriculares.domain.repository.ProfessorUnidadeCurricularRepository
import com.senaisp.carteirinhadigital.feature.turmas.domain.repository.TurmaRepository
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.domain.repository.UnidadeCurricularRepository

interface AppContainer {
    val sessionTokenStore: SessionTokenStore

    val loginRepository: LoginRepository

    val unidadeCurricularRepository: UnidadeCurricularRepository

    val turmaRepository: TurmaRepository

    val professorUnidadeCurricularRepository: ProfessorUnidadeCurricularRepository
}

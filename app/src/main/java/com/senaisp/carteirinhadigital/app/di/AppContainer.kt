package com.senaisp.carteirinhadigital.app.di

import com.senaisp.carteirinhadigital.core.auth.SessionTokenStore
import com.senaisp.carteirinhadigital.feature.login.domain.repository.LoginRepository
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.domain.repository.UnidadeCurricularRepository

interface AppContainer {
    val sessionTokenStore : SessionTokenStore

    val loginRepository : LoginRepository

    val unidadeCurricularRepository : UnidadeCurricularRepository
}

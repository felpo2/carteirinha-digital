package com.senaisp.carteirinhadigital.app.di

import com.senaisp.carteirinhadigital.core.auth.SessionTokenStore
import com.senaisp.carteirinhadigital.core.network.NetworkClient
import com.senaisp.carteirinhadigital.feature.login.data.remote.service.AuthApi
import com.senaisp.carteirinhadigital.feature.login.data.repository.ApiLoginRepositoryImpl
import com.senaisp.carteirinhadigital.feature.login.data.repository.FakeAuthRepository
import com.senaisp.carteirinhadigital.feature.login.domain.repository.LoginRepository
import com.senaisp.carteirinhadigital.feature.professor.unidadecurriculares.data.remote.service.ProfessorUnidadeCurricularApi
import com.senaisp.carteirinhadigital.feature.professor.unidadecurriculares.data.repository.ApiProfessorUnidadeCurricularRepositoryImpl
import com.senaisp.carteirinhadigital.feature.professor.unidadecurriculares.domain.repository.ProfessorUnidadeCurricularRepository
import com.senaisp.carteirinhadigital.feature.turmas.data.remote.service.TurmasApi
import com.senaisp.carteirinhadigital.feature.turmas.data.repository.ApiTurmaRepositoryImpl
import com.senaisp.carteirinhadigital.feature.turmas.domain.repository.TurmaRepository
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.data.remote.service.UnidadeCurricularApi
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.data.repository.ApiUnidadeCurricularRepositoryImpl
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.domain.repository.UnidadeCurricularRepository
import kotlin.getValue

class DefaultAppContainer : AppContainer {
    override val sessionTokenStore: SessionTokenStore = SessionTokenStore()
    private val networkClient =
        NetworkClient(
            baseUrl = BASE_URL,
            sessionTokenStore = sessionTokenStore
        )

    private val authApi: AuthApi by lazy {
        networkClient.createPublic(
            AuthApi::class.java
        )
    }
    private val unidadeCurricularApi: UnidadeCurricularApi by lazy {
        networkClient.createAuthenticated(
            UnidadeCurricularApi::class.java
        )
    }
    private val turmasApi: TurmasApi by lazy {
        networkClient.createAuthenticated(
            TurmasApi::class.java
        )
    }
    private val professorUnidadeCurricularApi: ProfessorUnidadeCurricularApi by lazy {
        networkClient.createAuthenticated(
            ProfessorUnidadeCurricularApi::class.java
        )
    }

    override val loginRepository: LoginRepository by lazy {
        if (USE_FAKE_LOGIN_REPOSITORY) {
            FakeAuthRepository()
        } else {
            ApiLoginRepositoryImpl(
                api = authApi
            )
        }
    }
    override val unidadeCurricularRepository: UnidadeCurricularRepository by lazy {
        ApiUnidadeCurricularRepositoryImpl(
            api = unidadeCurricularApi
        )
    }
    override val turmaRepository: TurmaRepository by lazy {
        ApiTurmaRepositoryImpl(
            api = turmasApi
        )
    }
    override val professorUnidadeCurricularRepository: ProfessorUnidadeCurricularRepository by lazy {
        ApiProfessorUnidadeCurricularRepositoryImpl(
            api = professorUnidadeCurricularApi
        )
    }

    companion object {
        private val BASE_URL = com.senaisp.carteirinhadigital.BuildConfig.API_BASE_URL
        private const val USE_FAKE_LOGIN_REPOSITORY = false
    }
}

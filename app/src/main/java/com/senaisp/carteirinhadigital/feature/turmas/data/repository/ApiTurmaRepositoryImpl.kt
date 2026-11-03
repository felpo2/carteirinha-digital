package com.senaisp.carteirinhadigital.feature.turmas.data.repository

import com.senaisp.carteirinhadigital.feature.turmas.data.remote.service.TurmasApi
import com.senaisp.carteirinhadigital.feature.turmas.domain.model.Turma
import com.senaisp.carteirinhadigital.feature.turmas.domain.repository.TurmaRepository
import java.io.IOException
import retrofit2.HttpException

class ApiTurmaRepositoryImpl(
    private val api: TurmasApi
) : TurmaRepository {

    override suspend fun listar(): Result<List<Turma>> {
        return runCatching {
            api.listar().map { it.toDomain() }
        }.recoverCatching { throwable ->
            throw when (throwable) {
                is HttpException -> {
                    if (throwable.code() == 401) {
                        IllegalStateException("Sua sessão expirou. Faça login novamente.")
                    } else {
                        IllegalStateException("Erro ao carregar turmas (${throwable.code()}).")
                    }
                }
                is IOException ->
                    IllegalStateException("Não foi possível conectar à API.")
                else ->
                    IllegalStateException(throwable.message ?: "Erro ao carregar turmas.")
            }
        }
    }
}

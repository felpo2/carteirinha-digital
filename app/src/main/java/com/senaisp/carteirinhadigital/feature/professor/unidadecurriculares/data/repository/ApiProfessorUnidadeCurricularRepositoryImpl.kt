package com.senaisp.carteirinhadigital.feature.professor.unidadecurriculares.data.repository

import com.senaisp.carteirinhadigital.feature.professor.unidadecurriculares.data.remote.service.ProfessorUnidadeCurricularApi
import com.senaisp.carteirinhadigital.feature.professor.unidadecurriculares.domain.model.UnidadeCurricularProfessor
import com.senaisp.carteirinhadigital.feature.professor.unidadecurriculares.domain.repository.ProfessorUnidadeCurricularRepository
import java.io.IOException
import retrofit2.HttpException

class ApiProfessorUnidadeCurricularRepositoryImpl(
    private val api: ProfessorUnidadeCurricularApi
) : ProfessorUnidadeCurricularRepository {

    override suspend fun listar(): Result<List<UnidadeCurricularProfessor>> {
        return runCatching {
            api.listar().map { it.toDomain() }
        }.recoverCatching { throwable ->
            throw when (throwable) {
                is HttpException -> {
                    if (throwable.code() == 401) {
                        IllegalStateException("Sua sessão expirou. Faça login novamente.")
                    } else {
                        IllegalStateException("Erro ao carregar unidades curriculares (${throwable.code()}).")
                    }
                }
                is IOException ->
                    IllegalStateException("Não foi possível conectar à API.")
                else ->
                    IllegalStateException(throwable.message ?: "Erro ao carregar unidades curriculares.")
            }
        }
    }
}

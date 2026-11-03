package com.senaisp.carteirinhadigital.feature.professor.unidadecurriculares.data.remote.service

import com.senaisp.carteirinhadigital.feature.professor.unidadecurriculares.data.remote.dto.UnidadeCurricularProfessorDto
import retrofit2.http.GET

interface ProfessorUnidadeCurricularApi {
    @GET("professores/me/unidades-curriculares")
    suspend fun listar(): List<UnidadeCurricularProfessorDto>
}

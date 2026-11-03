package com.senaisp.carteirinhadigital.feature.turmas.data.remote.service

import com.senaisp.carteirinhadigital.feature.turmas.data.remote.dto.TurmaProfessorDto
import retrofit2.http.GET

interface TurmasApi {
    @GET("professores/me/turmas")
    suspend fun listar(): List<TurmaProfessorDto>
}

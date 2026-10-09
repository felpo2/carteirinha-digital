package com.senaisp.carteirinhadigital.feature.unidadecurriculares.data.remote.service

import com.senaisp.carteirinhadigital.feature.unidadecurriculares.data.remote.dto.UnidadeCurricularDTO
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.data.remote.dto.UnidadeCurricularDto
import retrofit2.http.GET

interface UnidadeCurricularApi {

    @GET("unidades-curriculares")
    suspend fun listar(): List<UnidadeCurricularDto>
}
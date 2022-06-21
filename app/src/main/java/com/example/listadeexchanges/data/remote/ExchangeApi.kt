package com.example.listadeexchanges.data.remote

import com.example.listadeexchanges.data.remote.dto.ExchangeDto
import retrofit2.http.GET

interface ExchangeApi {
    @GET("/v1/exchanges")
    suspend fun getExchanges(): List<ExchangeDto>
}
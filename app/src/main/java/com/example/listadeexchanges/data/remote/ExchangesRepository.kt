package com.example.listadeexchanges.data.remote

import com.example.listadeexchanges.data.remote.dto.ExchangeDto
import com.example.listadeexchanges.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class ExchangesRepository @Inject constructor(
    private val api: ExchangeApi
) {
    fun getExchanges(): Flow<Resource<List<ExchangeDto>>> = flow {
        try {
            emit(Resource.Loading())

            val exchanges = api.getExchanges()

            emit(Resource.Success(exchanges))

        } catch (e: HttpException) {
            emit(Resource.Error(e.message ?: "Error HTTP general"))
        } catch (e: IOException) {
            emit(Resource.Error(e.message ?: "Verificar la conexion a internet"))
        }

    }
}
package com.example.listadeexchanges.data.remote.dto

data class ExchangeDto(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val active: Boolean = false,
    val last_updated: String = ""
)
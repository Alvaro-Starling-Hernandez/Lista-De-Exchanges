package com.example.listadeexchanges.ui.theme.Scrrens

import com.example.listadeexchanges.data.remote.dto.ExchangeDto

data class ExchangeListState(
    val isLoading: Boolean = false,
    val exchanges: List<ExchangeDto> = emptyList(),
    val error: String = ""
)